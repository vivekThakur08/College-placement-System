package com.cps.collegePlacementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String department;
    private String email;
    private String linkedIn;
    private String phone;

    private String batch;

    private String course;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private ParentDetails parentDetails;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<EducationDetails> educationDetails;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<SemesterDetails> semesterDetails;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Certification> certifications;

    @ElementCollection
    private List<String> skills;

    // Getters and Setters




    public Student(Long id, String name, String department, String email, String linkedIn, String phone,ParentDetails parentDetails, List<EducationDetails> educationDetails, List<SemesterDetails> semesterDetails, List<Certification> certifications, List<String> skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.linkedIn = linkedIn;
        this.phone = phone;
        this.parentDetails = parentDetails;
        this.educationDetails = educationDetails;
        this.semesterDetails = semesterDetails;
        this.certifications = certifications;
        this.skills = skills;
    }

}
