package ua.com.dribnichki.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.bridge.builtin.DoubleBridge;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Indexed
//@AnalyzerDef(name = "customanalyzer",
//        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
//        filters = {
//                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
//                @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
//                        @Parameter(name = "language", value = "English")
//                })
//        })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @DocumentId
    private int id;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//    @Analyzer(definition = "customanalyzer")
    private String productName;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//    @Analyzer(definition = "customanalyzer")
    @FieldBridge(impl = DoubleBridge.class)
    private double price;


  @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "product")
  @JsonIgnore
    private List<Photo> photoList = new ArrayList<>();

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//    @Analyzer(definition = "customanalyzer")
    private String Tab;

    private boolean isOnDiscount = false;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//    @Analyzer(definition = "customanalyzer")
    @Column (columnDefinition = "TEXT")
    private String description;

    private boolean isInStock = true;

    private boolean isOptionsAvalible = false;

    private double discount;

    @IndexedEmbedded
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Category category;

    @IndexedEmbedded
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "product")
//    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<ProductOption> productOptions = new ArrayList<>();


    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                Double.compare(product.getPrice(), getPrice()) == 0 &&
                isOnDiscount() == product.isOnDiscount() &&
                isInStock() == product.isInStock() &&
                isOptionsAvalible() == product.isOptionsAvalible() &&
                Double.compare(product.getDiscount(), getDiscount()) == 0 &&
                Objects.equals(getProductName(), product.getProductName()) &&
                Objects.equals(getTab(), product.getTab()) &&
                Objects.equals(getDescription(), product.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getProductName(), getPrice(), getTab(), isOnDiscount(), getDescription(), isInStock(), isOptionsAvalible(), getDiscount());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", Tab='" + Tab + '\'' +
                ", isOnDiscount=" + isOnDiscount +
                ", description='" + description + '\'' +
                ", isInStock=" + isInStock +
                ", isOptionsAvalible=" + isOptionsAvalible +
                ", discount=" + discount +
                '}';
    }

    public void addOption(ProductOption productOption){
       if(productOptions.contains(productOption))
           return;
       productOptions.add(productOption);
       productOption.setProduct(this);
    }

    public void removeOption(ProductOption productOption) {
        //prevent endless loop
        if (!productOptions.contains(productOption))
            return ;
        productOptions.remove(productOption);
        productOption.setProduct(null);
    }

//    public void removePhoto(Photo photo) {
//        //prevent endless loop
//        if (!photoList.contains(photo))
//            return ;
//        photoList.remove(photo);
//        photo.setProduct(null);
//    }
//
//    public void addPhoto(Photo photo) {
//        //prevent endless loop
//        if (photoList.contains(photo))
//            return ;
//        photoList.add(photo);
//        photo.setProduct(this);
//    }

    public List<ProductOption> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOption> productOptions) {
        this.productOptions = productOptions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public String getTab() {
        return Tab;
    }

    public void setTab(String tab) {
        Tab = tab;
    }

    public boolean isOnDiscount() {
        return isOnDiscount;
    }

    public void setOnDiscount(boolean onDiscount) {
        isOnDiscount = onDiscount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripiton) {
        this.description = descripiton;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public boolean isOptionsAvalible() {
        return isOptionsAvalible;
    }

    public void setOptionsAvalible(boolean optionsAvalible) {
        isOptionsAvalible = optionsAvalible;
    }

}
