package com.pawcare.demo.controller;

import com.pawcare.demo.model.User;
import com.pawcare.demo.repository.UserRepository;
import com.pawcare.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public RedirectView login(@RequestParam String email, @RequestParam String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        RedirectView redirectView = new RedirectView();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (!user.getRole().equals(User.Role.ADMIN)) {
                redirectView.setUrl("/error.html");
                return redirectView;
            }
            if (user.getPassword().equals(password)) {
                redirectView.setUrl("/adminPanel.html");
                return redirectView;
            }
        }

        redirectView.setUrl("/error.html");
        return redirectView;
    }

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(required = false) String role) {
        if (role != null) {
            try {
                User.Role userRole = User.Role.valueOf(role.toUpperCase());
                return adminService.getUsersByRole(userRole);
            } catch (IllegalArgumentException e) {
                return new ArrayList<>();
            }
        }
        return adminService.getAllUsers();
    }

    @PutMapping("/users/{id}/toggle-ban")
    public ResponseEntity<String> toggleBan(@PathVariable Long id) {
        String result = adminService.toggleUserBanStatus(id);
        if (result.contains("updated")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @GetMapping("/panel")
    public String showAdminPanel(Model model) {
        List<User> users = adminService.getAllUsers();
        model.addAttribute("users", users);
        return "adminPanel";
    }
}
