package ua.com.dribnichki.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dribnichki.dao.ProductDAO;
import ua.com.dribnichki.entity.Product;
import ua.com.dribnichki.service.ProductService;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDAO dao;

    @Override
    public void save(Product product) {
        dao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product findProductByName(String name) {
        return dao.findProductByName(name);
    }

    @Override
    public Product findOne(int id) {
        return dao.findOne(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
