package ua.com.dribnichki.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dribnichki.dao.ImgRepositoryDAO;
import ua.com.dribnichki.entity.ImgRepository;
import ua.com.dribnichki.service.ImgRepositoryService;

import java.util.List;

@Service
@Transactional
public class ImgRepositoryImpl implements ImgRepositoryService {


    @Autowired
    private ImgRepositoryDAO dao;

    @Override
    public void save(ImgRepository img) {
        dao.save(img);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<ImgRepository> findAll() {
        return dao.findAll();
    }

    @Override
    public ImgRepository findOne(int id) {
        return dao.findOne(id);
    }
}
