package com.kamelprojet.classyadmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TIME_SCHEDULE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Course> Course;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ClassGroup> classGroup;
}
