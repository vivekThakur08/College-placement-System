package com.cps.collegePlacementSystem.repositories;

import com.cps.collegePlacementSystem.model.ParentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentDetailsRepository extends JpaRepository<ParentDetails, Long> {
}

