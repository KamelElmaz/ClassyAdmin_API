package com.kamelprojet.classyadmin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "CLASS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "Name must be defined")
    private String name;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "Level must be defined")
    private String level;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<User> student;

    @ManyToOne(cascade = CascadeType.ALL)
    private User headTeacher;
}
