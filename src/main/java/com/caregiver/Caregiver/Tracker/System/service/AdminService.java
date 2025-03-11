package com.caregiver.Caregiver.Tracker.System.service;

import com.caregiver.Caregiver.Tracker.System.model.Admin;
import com.caregiver.Caregiver.Tracker.System.model.UserI;
import com.caregiver.Caregiver.Tracker.System.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin saveAdmin(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
}
