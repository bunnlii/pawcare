package com.pawcare.demo.Controller;

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

import java.time.LocalDateTime;
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

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getStatus() == User.Status.BANNED) {
                model.addAttribute("errorMessage", "Your account is banned. Please contact support.");
                return "redirect:/banned.html";
            }

            if (user.getPassword().equals(password)) {
                model.addAttribute("users", userRepository.findAll());
                return "redirect:/admin/adminPanel";
            } else {
                model.addAttribute("errorMessage", "Invalid password");
                return "redirect:/error.html";
            }
        }

        model.addAttribute("errorMessage", "Admin not found");
        return "redirect:/error.html";
    }

    @GetMapping("/adminPanel")
    public String adminPanel(Model model) {
        List<Review> reviews = reviewRepository.findAll();
        List<User> customers = userRepository.findByRole(User.Role.CUSTOMER);
        List<User> providers = userRepository.findByRole(User.Role.PROVIDER);
        List<Review> appointments = reviewRepository.findAll();

        List<User> users = userServices.getUsers();
        model.addAttribute("users", users);

        List<Review> flaggedReviews = reviewRepository.findByIsFlagged(true);
        model.addAttribute("flaggedReviews", flaggedReviews);

        long totalUsers = users.size();
        long totalReviews = reviews.size();
        long flaggedReviewsCount = flaggedReviews.size();
        long totalCustomers = customers.size();
        long totalProviders = providers.size();
        long totalAppointments = appointments.size();
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        long newUsersInLastMonth = users.stream()
                .filter(user -> user.getCreatedAt() != null && user.getCreatedAt().isAfter(oneMonthAgo))
                .count();

        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalReviews", totalReviews);
        model.addAttribute("flaggedReviewsCount", flaggedReviewsCount);
        model.addAttribute("totalCustomers", totalCustomers);
        model.addAttribute("totalProviders", totalProviders);
        model.addAttribute("totalAppointments", totalAppointments);
        model.addAttribute("newUsersInLastMonth", newUsersInLastMonth);

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
