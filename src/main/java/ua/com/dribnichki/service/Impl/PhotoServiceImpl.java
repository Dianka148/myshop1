package ua.com.dribnichki.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dribnichki.dao.PhotoDAO;
import ua.com.dribnichki.entity.Photo;
import ua.com.dribnichki.service.PhotoService;

import java.util.List;
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService{


    @Autowired
    private PhotoDAO dao;

    @Override
    public void save(Photo photo) {
        dao.save(photo);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<Photo> findAll() {
        return dao.findAll();
    }

    @Override
    public Photo findOne(int id) {
        return dao.findOne(id);
    }
}
