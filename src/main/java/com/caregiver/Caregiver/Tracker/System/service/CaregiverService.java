package com.caregiver.Caregiver.Tracker.System.service;

import com.caregiver.Caregiver.Tracker.System.model.Caregiver;
import com.caregiver.Caregiver.Tracker.System.model.Patient;
import com.caregiver.Caregiver.Tracker.System.repository.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CaregiverService{

    @Autowired
    private CaregiverRepository caregiverRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Caregiver> getAllCaregivers(){
        return caregiverRepository.findAll();
    }

    public Caregiver getCaregiverById(Integer id){
        return caregiverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Caregiver saveCaregiver(Caregiver caregiver){
        caregiver.setPassword(passwordEncoder.encode(caregiver.getPassword()));
        return caregiverRepository.save(caregiver);
    }

    public void deleteCaregiver(Integer id){
        caregiverRepository.deleteById(id);
    }

    public Optional<Caregiver> findByEmail(String email){
        return caregiverRepository.findByEmail(email);
    }

    public Set<Patient> getAllPatients(Caregiver caregiver){
        return caregiver.getPatients();
    }

}
