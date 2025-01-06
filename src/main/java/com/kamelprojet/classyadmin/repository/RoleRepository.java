package com.kamelprojet.classyadmin.repository;

import com.kamelprojet.classyadmin.TypeOfRole;
import com.kamelprojet.classyadmin.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(TypeOfRole name);
}
