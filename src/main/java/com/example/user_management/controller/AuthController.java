package com.example.user_management.controller;

import com.example.user_management.dto.SignupRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        return "Signup working: " + request.getEmail();
    }
}