package com.cps.collegePlacementSystem.service;

import com.cps.collegePlacementSystem.model.Job;
import com.cps.collegePlacementSystem.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Add a new job
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get job by ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Job not found with id: " + id)
        );
    }

    // Delete a job by ID
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found with id: " + id);
        }
        jobRepository.deleteById(id);
    }
}
