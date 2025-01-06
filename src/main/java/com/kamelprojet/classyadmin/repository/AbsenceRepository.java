package com.kamelprojet.classyadmin.repository;

import com.kamelprojet.classyadmin.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
