package ua.com.dribnichki.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dribnichki.dao.UserDAO;
import ua.com.dribnichki.entity.User;
import ua.com.dribnichki.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserDAO dao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);

    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findByUserName(String name) {
        return dao.findByUserName(name);
    }

    @Override
    public User findOne(int id) {
        return dao.findOne(id);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findByUserName(s);
    }
}
