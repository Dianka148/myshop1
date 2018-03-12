package ua.com.dribnichki.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.dribnichki.entity.Product;

public interface ProductDAO extends JpaRepository<Product,Integer> {
    @Query("from Product p where p.productName = :name ")
    Product findProductByName(@Param("name") String name);
}
