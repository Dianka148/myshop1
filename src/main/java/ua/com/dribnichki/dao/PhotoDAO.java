package ua.com.dribnichki.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.dribnichki.entity.Photo;

public interface PhotoDAO extends JpaRepository<Photo, Integer> {
}
