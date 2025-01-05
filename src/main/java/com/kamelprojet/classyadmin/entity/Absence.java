package com.kamelprojet.classyadmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ABSENCE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean justified;

    @ManyToOne(cascade = CascadeType.ALL)
    private User student;

    @ManyToOne(cascade = CascadeType.ALL)
    private TimeSchedule timeSchedule;
}
