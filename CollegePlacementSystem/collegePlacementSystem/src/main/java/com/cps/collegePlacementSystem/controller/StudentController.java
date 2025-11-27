package com.cps.collegePlacementSystem.controller;


import com.cps.collegePlacementSystem.model.Student;
import com.cps.collegePlacementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {


    @Autowired
    private StudentService studentService;

//    @GetMapping("/eligible")
//    public ResponseEntity<List<Student>> getEligibleStudents(@RequestParam double minCgpa) {
//        List<Student> students = studentService.getAllEligibleStudents(minCgpa);
//        return new ResponseEntity<>(students, HttpStatus.OK);
 //   }

//    @CrossOrigin(origins = "*")
//    @PostMapping("/register")
//    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
//        Student registeredStudent = studentService.registerStudent(student);
//        return new ResponseEntity<>(registeredStudent, HttpStatus.CREATED);
//    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}