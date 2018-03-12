package ua.com.dribnichki.service;

import ua.com.dribnichki.entity.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    void delete(int id);
    List<Category> findAll();
    Category findOne (int id);
    Category findByCategoryName(String name);
}
