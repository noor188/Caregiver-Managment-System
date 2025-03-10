package com.caregiver.Caregiver.Tracker.System.service;

import com.caregiver.Caregiver.Tracker.System.model.Admin;
import com.caregiver.Caregiver.Tracker.System.model.Caregiver;
import com.caregiver.Caregiver.Tracker.System.model.Patient;
import com.caregiver.Caregiver.Tracker.System.model.UserI;
import com.caregiver.Caregiver.Tracker.System.repository.AdminRepository;
import com.caregiver.Caregiver.Tracker.System.repository.CaregiverRepository;
import com.caregiver.Caregiver.Tracker.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private CaregiverRepository caregiverRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Try to find the user as an admin
        Optional<Admin> admin = adminRepository.findByEmail(email);
        if (admin.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    admin.get().getEmail(),
                    admin.get().getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))  // Correct role
            );
        }

        // Try to find the user as a patient
        Optional<Patient> patient = patientRepository.findByEmail(email);
        if (patient.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    patient.get().getEmail(),
                    patient.get().getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_PATIENT"))  // Correct role
            );
        }

        // Try to find the user as a caregiver
        Optional<Caregiver> caregiver = caregiverRepository.findByEmail(email);
        if (caregiver.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    caregiver.get().getEmail(),
                    caregiver.get().getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_CAREGIVER"))  // Correct role
            );
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }

}