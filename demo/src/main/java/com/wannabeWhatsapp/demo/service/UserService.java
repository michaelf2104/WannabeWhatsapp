package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(String id) {
        return users.get(id);
    }

    public User createUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public void deleteUser(String id) {
        users.remove(id);
    }
}
