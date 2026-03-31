package com.example.user_management.controller;

import com.example.user_management.dto.SignupRequest;
import com.example.user_management.model.User;
import com.example.user_management.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest request) {
        return userService.registerUser(request);
    }
}