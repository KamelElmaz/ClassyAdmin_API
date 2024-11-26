package com.kamelprojet.classyadmin.repository;

import com.kamelprojet.classyadmin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String email);
}
