package ua.com.dribnichki.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.dribnichki.entity.ImgRepository;

public interface ImgRepositoryDAO extends JpaRepository<ImgRepository, Integer> {
}
