package ua.com.dribnichki.service;

import ua.com.dribnichki.entity.ProductOption;

import java.util.List;

public interface ProductOptionService {
    void save(ProductOption productOption);
    void delete(int id);
    List<ProductOption> findAll();
    ProductOption findOne(int id);
}
