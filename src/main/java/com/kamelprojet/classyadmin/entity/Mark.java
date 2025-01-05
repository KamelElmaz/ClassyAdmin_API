package com.kamelprojet.classyadmin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MARK")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float value;

    @Column(nullable = false)
    private float coefficient;

    @ManyToOne(cascade = CascadeType.ALL)
    private User student;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    private TimeSchedule timeSchedule;
}
