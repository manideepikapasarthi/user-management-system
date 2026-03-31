package com.example.user_management.service;

import com.example.user_management.dto.SignupRequest;
import com.example.user_management.model.User;
import com.example.user_management.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(SignupRequest request) {

        // 🔴 Duplicate email check
        if (userRepository.findAll()
                .stream()
                .anyMatch(user -> user.getEmail().equals(request.getEmail()))) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setEmail(request.getEmail());

        // 🔐 Encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setName(request.getName());

        return userRepository.save(user);
    }
}