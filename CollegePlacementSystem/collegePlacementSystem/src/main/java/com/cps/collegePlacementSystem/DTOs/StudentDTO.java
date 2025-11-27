package com.cps.collegePlacementSystem.DTOs;

import com.cps.collegePlacementSystem.model.Certification;
import com.cps.collegePlacementSystem.model.EducationDetails;
import com.cps.collegePlacementSystem.model.ParentDetails;
import com.cps.collegePlacementSystem.model.SemesterDetails;

import java.util.List;

public class StudentDTO {
    private String name;
    private String department;
    private String email;
    private String linkedIn;
    private String phone;
    private String batch;
    private String course;
    private ParentDetails parentDetails;
    private List<EducationDetails> educationDetails;
    private List<SemesterDetails> semesterDetails;
    private List<Certification> certifications;
    private List<String> skills;

    // Getters and Setters
}

