package com.pawcare.demo.controller;

import com.pawcare.demo.model.Review;
import com.pawcare.demo.repository.ReviewRepository;
import com.pawcare.demo.service.UserServices;
import com.pawcare.demo.model.User;
import com.pawcare.demo.repository.UserRepository;
import com.pawcare.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ReviewRepository reviewRepository;


    @GetMapping("/login")
    public String loginPage() {
        return "adminLoginPage";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> userOptional = userRepository.findByEmailAndRole(email, User.Role.ADMIN);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            model.addAttribute("users", userServices.getUsers());

            List<Review> flaggedReviews = reviewRepository.findByIsFlagged(true);
            model.addAttribute("flaggedReviews", flaggedReviews);

            return "redirect:/admin/adminPanel";
        }
        return "error";
    }


    @GetMapping("/adminPanel")
    public String adminPanel(Model model) {
        List<User> users = userServices.getUsers();
        model.addAttribute("users", users);

        List<Review> flaggedReviews = reviewRepository.findByIsFlagged(true);
        model.addAttribute("flaggedReviews", flaggedReviews);

        return "adminPanel";
    }

    @GetMapping("/users")
    @ResponseBody
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
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getStatus() == User.Status.BANNED) {
                user.setStatus(User.Status.ACTIVE);
            } else {
                user.setStatus(User.Status.BANNED);
            }
            userRepository.save(user);
            return ResponseEntity.ok("User status updated.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
