package com.cps.collegePlacementSystem.repositories;

import com.cps.collegePlacementSystem.model.EducationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDetailsRepository extends JpaRepository<EducationDetails, Long> {
}
