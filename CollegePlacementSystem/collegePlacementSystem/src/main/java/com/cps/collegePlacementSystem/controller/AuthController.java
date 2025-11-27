package com.cps.collegePlacementSystem.controller;

import com.cps.collegePlacementSystem.exceptions.InvalidCredentialsException;
import com.cps.collegePlacementSystem.model.User;
import com.cps.collegePlacementSystem.payload.AuthenticationResponse;
import com.cps.collegePlacementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private UserService userService;


    @CrossOrigin(origins = "*")
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        try {
            userService.registerUser(user.getEmail(),user.getPassword(), user.getRole());
            return "User registered successfully!";
        } catch (Exception e) {
            return e.getMessage(); // Return error if username exists
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User user) {
        boolean isAuthenticated = userService.validateUser(user.getEmail(), user.getPassword());

        if (isAuthenticated) {
            String role = userService.getUserRole(user.getEmail());
            return ResponseEntity.ok(new AuthenticationResponse(role));
        } else {
            throw new InvalidCredentialsException("Invalid username or password!");
        }
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @GetMapping("/home")
    public String home() {

        return "This is homepage";
    }
}

