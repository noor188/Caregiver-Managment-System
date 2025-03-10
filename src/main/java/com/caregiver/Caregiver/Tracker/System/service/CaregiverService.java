package com.caregiver.Caregiver.Tracker.System.service;

import com.caregiver.Caregiver.Tracker.System.model.Caregiver;
import com.caregiver.Caregiver.Tracker.System.repository.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaregiverService {

    @Autowired
    private CaregiverRepository caregiverRepository;

    public List<Caregiver> getAllCaregivers(){
        return caregiverRepository.findAll();
    }

    public Caregiver getCaregiverById(Integer id){
        return caregiverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Caregiver saveCaregiver(Caregiver caregiver){
        return caregiverRepository.save(caregiver);
    }

    public void deleteCaregiver(Integer id){
        caregiverRepository.deleteById(id);
    }

}
