package com.pawcare.demo.service;

import com.pawcare.demo.model.User;
import com.pawcare.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByRole(User.Role role) {
        return userRepository.findByRole(role);
    }

    public String toggleUserBanStatus(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            User.Status currentStatus = user.getStatus();

            if (currentStatus == User.Status.BANNED) {
                user.setStatus(User.Status.ACTIVE);
            } else {
                user.setStatus(User.Status.BANNED);
            }

            userRepository.save(user);
            return "User status updated to " + user.getStatus();
        } else {
            return "User not found";
        }
    }

}
