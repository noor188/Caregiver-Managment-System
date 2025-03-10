package com.caregiver.Caregiver.Tracker.System.service;

import com.caregiver.Caregiver.Tracker.System.model.Patient;
import com.caregiver.Caregiver.Tracker.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(Integer id){
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public void deletePatient(Integer id){
        patientRepository.deleteById(id);
    }

}
