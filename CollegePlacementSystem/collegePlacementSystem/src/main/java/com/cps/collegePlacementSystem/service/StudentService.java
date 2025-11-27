package com.cps.collegePlacementSystem.service;

import com.cps.collegePlacementSystem.model.Student;

import java.util.List;

public interface StudentService {


//List<Student> getAllEligibleStudents(double minCgpa);
//Student registerStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    Student saveStudent(Student student);

    void deleteStudent(Long id);


    Student registerStudent(Student student);


   List<Student> getAllStudents();
}
