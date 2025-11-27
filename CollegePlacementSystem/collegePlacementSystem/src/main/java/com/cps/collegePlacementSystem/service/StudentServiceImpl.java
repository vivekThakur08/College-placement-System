package com.cps.collegePlacementSystem.service;


import com.cps.collegePlacementSystem.model.Student;
import com.cps.collegePlacementSystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        // Return a list of students from the repository
        return studentRepository.findAll();
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setDepartment(updatedStudent.getDepartment());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setLinkedIn(updatedStudent.getLinkedIn());
        existingStudent.setPhone(updatedStudent.getPhone());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }



//    @Override
//    public List<Student> getAllEligibleStudents(double minCgpa) {
//        return studentRepository.findByCgpaGreaterThan(minCgpa);
//    }
//

}
