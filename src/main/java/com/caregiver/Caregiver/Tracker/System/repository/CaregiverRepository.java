package com.caregiver.Caregiver.Tracker.System.repository;


import com.caregiver.Caregiver.Tracker.System.model.Caregiver;
import com.caregiver.Caregiver.Tracker.System.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {
    Optional<Caregiver> findByEmail(String email);
}
