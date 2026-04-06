package com.bridgelabz.hms.controller;

import com.bridgelabz.hms.config.JwtService;
import com.bridgelabz.hms.entity.User;
import com.bridgelabz.hms.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = authService.login(user.getEmail(), user.getPassword());

        if (existingUser != null) {
            return jwtService.generateToken(existingUser.getEmail()); // 🔥 safer
        }

        return "Invalid credentials";
    }
}