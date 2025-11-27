package com.cps.collegePlacementSystem.service;

import com.cps.collegePlacementSystem.model.User;
import com.cps.collegePlacementSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String email, String password, String role) {
        if (userRepository.findByEmail(email) != null) {
            throw new IllegalStateException("Username already exists!");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);


        return userRepository.save(user);
    }

    public boolean validateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user==null) {
            System.out.println("User not found with user ID: " + email);
            return false;
        }
        System.out.println("User found: " + email); // Added log for user retrieval

        boolean passwordMatches = passwordEncoder.matches(password, user.getPassword());

        if (!passwordMatches) {
            System.out.println("Password mismatch for user: " + email);
        } else {
            System.out.println("Password matches for user: " + email); // Log for successful match
        }

        return passwordMatches;
    }

    public String getUserRole(String email) {
        // Fetch user from database by email and return the role
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getRole();
        } else {
            throw new RuntimeException("User not found!");
        }
    }
}

