package ua.com.dribnichki.service;

import ua.com.dribnichki.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findByUserName(String name);
    User findOne(int id);
}
