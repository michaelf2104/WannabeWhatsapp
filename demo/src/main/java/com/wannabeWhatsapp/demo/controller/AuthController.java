package com.wannabeWhatsapp.demo.controller;

import com.wannabeWhatsapp.demo.model.User;
import com.wannabeWhatsapp.demo.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * handles user registration
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
         return authService.registerUser(user);
    }

    /**
     * handles user login
     */
    @PostMapping
    public boolean loginUser(@RequestBody Map<String, String> credentials) {
        return authService.verifyUser(credentials.get("phoneNumber"), credentials.get("password"));
    }

}
