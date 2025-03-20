package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.User;
import com.wannabeWhatsapp.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * registres a new user in the system
     */
    // TODO: do password encryption
    public String registerUser(User user) {
        try {
            if (userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent()) {
                logger.warn("Registration failed: Phone number already in use");
                return "Phone number already in use";
            }

            userRepository.save(user);
            logger.info("Registration successful");
            return "Registration successful";
        } catch (Exception e) {
            logger.error("Registration failed", e);
            return "Registration failed";
        }
    }

    /**
     * verifies user login by checking phone number and password
     */
    public boolean verifyUser(String phoneNumber, String password) {
        try {
            Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
            if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
                logger.info("User is valid");
                return true;
            } else {
                logger.warn("User is not valid");
                return false;
            }
        } catch (Exception e) {
            logger.error("Verify failed", e);
            return false;
        }
    }

}
