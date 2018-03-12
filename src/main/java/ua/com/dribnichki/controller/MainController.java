package ua.com.dribnichki.controller;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.dribnichki.entity.*;
import ua.com.dribnichki.service.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImgRepositoryService imgRepositoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private ProductOptionService productOptionService;

    @Autowired
    private MailService mailService;



//    @Autowired
//    private SessionFactory sessionFactory;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String index1(){
        return "redirect:/";
    }

    @GetMapping("/shop")
    public String shop(){
        return "shop";
    }

    @GetMapping("/delivery")
    public String delivery(){
        return "delivery";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/adm")
    public String adm(){
        return "adm";
    }

    @GetMapping("/add-product")
    public String addproduct(){
        return "add-product";
    }

    @GetMapping("/image-repository")
    public String imagerepository(Model model){
        model.addAttribute("images", imgRepositoryService.findAll() );
        return "image-repository";
    }

    @PostMapping("/add-image")
    public String addimage(@RequestParam ("image") List<MultipartFile> files){
        String path = System.getProperty("user.home") + File.separator + "postImage\\";
        files.forEach(file->{
            try {
                file.transferTo(new File(path  + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImgRepository image = new ImgRepository();
            image.setPathToImg("\\postImage\\" + file.getOriginalFilename());
            imgRepositoryService.save(image);
        });

        return "redirect:/image-repository";
    }

    @PostMapping("/delete-{id}")
    public String delete(@PathVariable int id){
        ImgRepository image = imgRepositoryService.findOne(id);
        File file = new File(System.getProperty("user.home") + File.separator + image.getPathToImg());
        if (file.delete()) System.out.println("Successfully deleted");
        else System.out.println("Nothing to delete");
        imgRepositoryService.delete(id);
        return "redirect:/image-repository";
    }

    @GetMapping("/category-management")
    public String categorymanagement(Model model){
        model.addAttribute("categories", categoryService.findAll() );
        return "category-management";
    }

    @GetMapping("/add-category")
    public String addcategory(@RequestParam("categoryName") String categoryName){
        Category category = new Category(categoryName);
        if (!categoryName.isEmpty()) categoryService.save(category);
        return "redirect:/category-management";
    }

    @GetMapping("/delete-category-{id}")
    public String deletecategory(@PathVariable int id){
     categoryService.delete(id);
     return "redirect:category-management";
    }

    @GetMapping("/product-management")
    public String productmanagement(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productService.findAll() );
        return "product-management";
    }

    @PostMapping("/add-product")
    public String addproduct(@RequestParam ("nameprod") String nameprod,
                             @RequestParam ("files") List<MultipartFile> files,
                             @RequestParam ("price") double price,
                             @RequestParam ("isDiscount") boolean isDiscount,
                             @RequestParam ("discount") double discount,
                             @RequestParam ("description") String description,
                             @RequestParam ("tab") String tab,
                             @RequestParam ("isInStock") boolean isInStock,
                             @RequestParam ("isOptionAvailable") boolean isOptionAvailable,
                             @RequestParam ("categories") int categories,
                             @RequestParam ("options") String options){
        Product product = new Product();
        product.setProductName(nameprod);
        product.setPrice(price);
        product.setOnDiscount(isDiscount);
        product.setDescription(description);
        product.setDiscount(discount);
        product.setTab(tab);
        product.setInStock(isInStock);
        product.setOptionsAvalible(isOptionAvailable);
        product.setCategory(categoryService.findOne(categories));
        String [] opt;
        System.out.println(options);
        productService.save(product);
        String path = System.getProperty("user.home") + File.separator + "postImage\\";
        files.forEach(file->{
            try {
                file.transferTo(new File(path  + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Photo image = new Photo();
            image.setPathToPhoto("\\postImage\\" + file.getOriginalFilename());
            image.setProduct(product);
            product.getPhotoList().add(image);
            photoService.save(image);  // detached entity passed to persist
            System.out.println("фото додано");
            System.out.println("Added to list photo");
        });
        if (isOptionAvailable) {
            opt = options.split(",");
            for (String option: opt){
                System.out.println(option);
                ProductOption productOption1 = new ProductOption();
                productOption1.setOptionName(option);
                productOption1.setProduct(product);
                product.getProductOptions().add(productOption1);
                productOptionService.save(productOption1);
                System.out.println("Опцію додано");
                System.out.println("added to list option");
            }
        }



        return "redirect:product-management";
    }


    @GetMapping("/search")
    public String search(@RequestParam ("valueToSearch") String valueToSearch,
                         Model model){
        System.out.println(valueToSearch);
        EntityManager em = entityManagerFactory.createEntityManager();
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        em.getTransaction().begin();

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Product.class)
                .get();

        org.apache.lucene.search.Query luceneQuerry = qb.keyword()
                .onFields("productName",
                "price",
                "Tab",
                "description",
                "category.categoryName" )
                .matching(valueToSearch)
                .createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuerry, Product.class);

        List result = jpaQuery.getResultList();

        for (Object obj: result){
            System.out.println(obj.toString());
        }
        model.addAttribute("results", result);

        em.getTransaction().commit();
        em.close();

        return "search";
    }


    @PostMapping("/delete-product-{id}")
    public String deleteProduct(@PathVariable int id){

        Product product = productService.findOne(id);
        product.getPhotoList().forEach( e -> photoService.delete(e.getId()));
        product.getProductOptions().forEach( e -> productOptionService.delete(e.getId()));
        productService.delete(id);
        return "redirect:product-management";
    }

    @GetMapping("/category")
    public String category(Model model){
        List<Product> products = productService.findAll();
        Map< String, String[]> productsMap = new HashMap<>();
        products.forEach( product -> {
            String [] prodInfo = {String.valueOf(product.getId()), product.getProductName(), product.getDescription(),
                                  product.getPhotoList().get(0).getPathToPhoto(), String.valueOf(product.getPrice())};
            productsMap.put( product.getProductName(),prodInfo);
        });
//        Iterator iterator = productsMap.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry pair = (Map.Entry)iterator.next();
//            System.out.println(pair.getKey() + "  " + pair.getValue());
//            iterator.remove();
//        }
        model.addAttribute("products" , productsMap);

        return "category";
    }

    @GetMapping("/checkout")
    public String checkout(){

        return "checkout";
    }

    @PostMapping("/send-bill")
    public String sendBill(@RequestParam("id") int id,
                           @RequestParam("email") String email){
        System.out.println(productService.findOne(id));
        System.out.println(email);
        String text = "ПРОДУКТ, ЯКИЙ ВИ ЗАМОВИЛИ: " + productService.findOne(id).getProductName() + "\n" +
                    "З ВАС : " + productService.findOne(id).getPrice() + "\n" +
                    "ДЯКОЮ ЗА ЗАМОВЛЕННЯ!";
        mailService.send(email, "Замовлення", text);
        return "redirect:checkout";
    }


}
