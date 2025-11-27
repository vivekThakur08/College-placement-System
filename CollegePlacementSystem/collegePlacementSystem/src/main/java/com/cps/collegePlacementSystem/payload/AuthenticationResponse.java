package com.cps.collegePlacementSystem.payload;

public class AuthenticationResponse {
    private String role;

    public AuthenticationResponse(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
