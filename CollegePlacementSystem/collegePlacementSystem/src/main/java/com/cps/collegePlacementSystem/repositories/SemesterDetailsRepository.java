package com.cps.collegePlacementSystem.repositories;

import com.cps.collegePlacementSystem.model.SemesterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterDetailsRepository extends JpaRepository<SemesterDetails, Long> {
}

