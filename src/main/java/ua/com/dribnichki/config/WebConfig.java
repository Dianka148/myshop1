package ua.com.dribnichki.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("ua.com.dribnichki")
@PropertySource("classpath:email.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

    @Bean
    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("email.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("email.port")));
        mailSender.setUsername(env.getProperty("email.username"));
        mailSender.setPassword(env.getProperty("email.password"));
        Properties properties = mailSender.getJavaMailProperties();
        properties.put(env.getProperty("email.protocol"), env.getProperty("email.protocol.val"));
        properties.put(env.getProperty("email.auth"), env.getProperty("email.auth.val"));
        properties.put(env.getProperty("email.starttls"), env.getProperty("email.starttls.val"));
        properties.put(env.getProperty("email.mail.debug"), env.getProperty("email.mail.debug.val"));
        return mailSender;
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/resources/");
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
        registry.addResourceHandler("/userAvatar/**")
                .addResourceLocations("file:"+System.getProperty("user.home") + File.separator + "usersImage\\");
        registry.addResourceHandler("/postImage/**")
                .addResourceLocations("file:"+System.getProperty("user.home") + File.separator + "postImage\\");
    }
}
