package ua.com.dribnichki.service;

import ua.com.dribnichki.entity.ImgRepository;

import java.util.List;

public interface ImgRepositoryService {
    void save(ImgRepository img);
    void delete(int id);
    List<ImgRepository> findAll();
    ImgRepository findOne (int id);
}
