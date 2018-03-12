package ua.com.dribnichki.service;

import ua.com.dribnichki.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    List<Product> findAll();
    Product findProductByName (String name);
    Product findOne (int id);
    void delete (int id);
}
