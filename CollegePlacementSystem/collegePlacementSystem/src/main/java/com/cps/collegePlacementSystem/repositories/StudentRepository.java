package com.cps.collegePlacementSystem.repositories;

import com.cps.collegePlacementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {




}
