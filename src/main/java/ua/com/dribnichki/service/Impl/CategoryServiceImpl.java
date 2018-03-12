package ua.com.dribnichki.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dribnichki.dao.CategoryDAO;
import ua.com.dribnichki.entity.Category;
import ua.com.dribnichki.service.CategoryService;

import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO dao;

    @Override
    public void save(Category category) {
        dao.save(category);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findOne(int id) {
        return dao.findOne(id);
    }

    @Override
    public Category findByCategoryName(String name) {
        return dao.findByCategoryName(name);
    }
}
