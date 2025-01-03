package com.kamelprojet.classyadmin.entity;

import com.kamelprojet.classyadmin.TypeOfRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 100, nullable = false)
    private TypeOfRole name;
}
