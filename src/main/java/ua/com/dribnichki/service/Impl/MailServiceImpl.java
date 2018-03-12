package ua.com.dribnichki.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.com.dribnichki.entity.Product;
import ua.com.dribnichki.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void send(String to, String subject, String text) {
//    public void send(Product product, String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sezonni.dribnychky@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);

        SimpleMailMessage messageForMe = new SimpleMailMessage();
        messageForMe.setFrom("sezonni.dribnychky@gmail.com");
        messageForMe.setTo("sezonni.dribnychky@gmail.com");
        messageForMe.setSubject("Нове замовлення для Вас");
        messageForMe.setText("Замовлення прийнято:" +"\n" +
                text+"\n\n" +
                "ТЕЛЕФОН: 0508380879");

        javaMailSender.send(messageForMe);

//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//
//        try {
//            mimeMessage.setFrom(new InternetAddress("sezonni.dribnychky@gmail.com"));
//            helper.setTo(email);
//            helper.setSubject("ЗАМОВЛЕННЯ");
//            helper.setText("ПРОДУКТ, ЯКИЙ ВИ ЗАМОВИЛИ: " + product.getProductName() + "\n" +
//                    "З ВАС : " + product.getPrice() + "\n" +
//                    "ДЯКОЮ ЗА ЗАМОВЛЕННЯ!" );
//            System.out.println("ПРОДУКТ, ЯКИЙ ВИ ЗАМОВИЛИ: " + product.getProductName() + "\n" +
//                    "З ВАС : " + product.getPrice() + "\n" +
//                    "ДЯКОЮ ЗА ЗАМОВЛЕННЯ!");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//            javaMailSender.send(mimeMessage);
//
    }
}
