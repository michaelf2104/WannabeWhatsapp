package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.User;
import com.wannabeWhatsapp.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * registres a new user in the system
     */
    public String registerUser(User user) {
        Optional<User> existingUser = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (existingUser.isPresent()) {
            return "Phone number already in use!";
        }

        // encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    /**
     * verifies user login by checking phone number and password
     */
    public boolean verifyUser(String phoneNumber, String password) {
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
        return user.isPresent() && passwordEncoder.matches(password, user.get().getPassword());
    }

}
