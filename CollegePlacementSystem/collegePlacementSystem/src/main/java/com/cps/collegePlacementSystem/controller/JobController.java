package com.cps.collegePlacementSystem.controller;


import com.cps.collegePlacementSystem.model.Job;
import com.cps.collegePlacementSystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // Add a new job
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        Job savedJob = jobService.addJob(job);
        return ResponseEntity.ok(savedJob);
    }

    // Get all jobs
    @CrossOrigin(origins = "*")
    @GetMapping("/getAll")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    // Get job by ID
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    // Delete job by ID
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully");
    }
}

