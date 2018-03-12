package ua.com.dribnichki.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.dribnichki.entity.Product;
import ua.com.dribnichki.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    ProductService productService;


    @GetMapping("/sendList")
    public Map<String, String[]> sendList(){
        List<Product> products = productService.findAll();
        Map< String, String[]> productsMap = new HashMap<>();
        products.forEach( product -> {
            String pathToPhoto =  product.getPhotoList().get(0).getPathToPhoto();
            String [] prodInfo = {String.valueOf(product.getId()), product.getProductName(), product.getDescription(),
                   pathToPhoto.replaceAll("\\\\", "/"), String.valueOf(product.getPrice())};
            productsMap.put( product.getProductName(),prodInfo);
        });
        return productsMap;
    }
}
