package com.bridgelabz.hms.service;

import com.bridgelabz.hms.entity.User;
import com.bridgelabz.hms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return "User already exists";
        }

        user.setRole(user.getRole()); // simple for now
        userRepository.save(user);

        return "User registered successfully";
    }

    public User login(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }

        return null;
    }
}