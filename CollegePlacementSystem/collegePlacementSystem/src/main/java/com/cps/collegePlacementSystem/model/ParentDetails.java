package com.cps.collegePlacementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ParentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String parentName;
    @Getter  @Setter
    private String parentPhone;
    @Getter  @Setter
    private String address;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Getters and Setters
}

