package ua.com.dribnichki.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.dribnichki.entity.ProductOption;

public interface OptionDAO extends JpaRepository<ProductOption, Integer> {

}
