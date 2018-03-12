package ua.com.dribnichki.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dribnichki.dao.OptionDAO;
import ua.com.dribnichki.entity.ProductOption;
import ua.com.dribnichki.service.ProductOptionService;

import java.util.List;

@Service
@Transactional
public class ProductOptionServiceImpl implements ProductOptionService {
    @Autowired
    OptionDAO dao;


    @Override
    public void save(ProductOption productOption) {
        dao.save(productOption);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<ProductOption> findAll() {
        return dao.findAll();
    }

    @Override
    public ProductOption findOne(int id) {
        return dao.findOne(id);
    }
}
