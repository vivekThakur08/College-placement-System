package com.cps.collegePlacementSystem.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter @Setter
    @Column(nullable = false)
    private String companyId;

    @Getter @Setter
    @Column(nullable = false)
    private String companyName;

    @Getter @Setter
    @Column(nullable = false)
    private String industry;

    @Getter @Setter
    @Column(nullable = false)
    private String batch;

    @Getter @Setter
    @Column(nullable = false)
    private String location;

    @Getter @Setter
    @Column(nullable = false)
    private String ctc;

    @Getter @Setter
    private String eligibility; // UG Aggregate Min

    @Getter @Setter
    private String xiiMin; // XIIth % Min

    @Getter @Setter
    private String xMin; // Xth % Min

    @Getter @Setter
    private String jdLink; // Job Description PDF Link

    @Getter @Setter
    private String companyUrl;
}
