package ua.com.dribnichki.config;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ua.com.dribnichki.dao")
@PropertySource("classpath:db.properties")
public class DataConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setUrl(env.getProperty("db.url"));
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        return vendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(vendorAdapter());
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(env.getProperty("db.packageToScan"));
        Properties properties = new Properties();
        properties.put(env.getProperty("db.hibernate.hbm2ddl"),
                       env.getProperty("db.hibernate.hbm2ddl.values"));
        properties.put(env.getProperty("db.hibernate.search.directory_provider"),
                       env.getProperty("db.hibernate.search.directory_provider.value"));
        properties.put(env.getProperty("db.hibernate.search.default.indexBase"),
                       env.getProperty("db.hibernate.search.default.indexBase.value"));

        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }



    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

//    @Bean
//    public LocalSessionFactoryBean sessionFactory(){
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(env.getProperty("db.packageToScan"));
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//
//    Properties hibernateProperties() {
//        return new Properties() {
//            {
//                setProperty("hibernate.hbm2ddl.auto",
//                        env.getProperty("db.hibernate.hbm2ddl"));
//                setProperty("hibernate.dialect",
//                        env.getProperty("hibernate.dialect"));
//                setProperty("hibernate.globally_quoted_identifiers",
//                        "true");
//            }
//        };
//    }


}
