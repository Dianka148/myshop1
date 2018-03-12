package ua.com.dribnichki.service;

import ua.com.dribnichki.entity.Product;
import ua.com.dribnichki.entity.User;

public interface MailService {
//    void send(Product product, String email);
void send(String to, String subject, String text);
}
