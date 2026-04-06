package com.bridgelabz.hms.controller;

import com.bridgelabz.hms.entity.User;
import com.bridgelabz.hms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register API
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    // Login API
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = authService.login(user.getEmail(), user.getPassword());

        if (existingUser != null) {
            return "Login successful";
        }

        return "Invalid credentials";
    }
}