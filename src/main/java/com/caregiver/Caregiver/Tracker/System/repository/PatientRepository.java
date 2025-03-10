package com.caregiver.Caregiver.Tracker.System.repository;

import com.caregiver.Caregiver.Tracker.System.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
