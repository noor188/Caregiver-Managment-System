package com.caregiver.Caregiver.Tracker.System.controller;

import com.caregiver.Caregiver.Tracker.System.model.Admin;
import com.caregiver.Caregiver.Tracker.System.model.Patient;
import com.caregiver.Caregiver.Tracker.System.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private AdminService adminService;

    // Show the home page
    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    // Show the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Show the registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("admin", new Admin());  // Pass an empty Employee object to the form
        return "register";
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("admin") Admin admin) {
        // Assign the role based on the form selection (either EMPLOYEE or ADMIN)
        adminService.saveAdmin(admin);  // Save the employee with their selected role
        return "redirect:/login";  // Redirect to the login page
    }


}