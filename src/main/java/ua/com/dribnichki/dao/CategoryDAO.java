package ua.com.dribnichki.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.dribnichki.entity.Category;
import ua.com.dribnichki.entity.Product;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
    @Query("from Category p where p.categoryName = :name ")
    Category findByCategoryName(@Param("name") String name);
}
