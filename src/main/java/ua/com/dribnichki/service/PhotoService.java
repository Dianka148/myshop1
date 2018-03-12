package ua.com.dribnichki.service;

import ua.com.dribnichki.entity.Photo;

import java.util.List;

public interface PhotoService {
    void save(Photo photo);
    void delete(int id);
    List<Photo> findAll();
    Photo findOne (int id);
}
