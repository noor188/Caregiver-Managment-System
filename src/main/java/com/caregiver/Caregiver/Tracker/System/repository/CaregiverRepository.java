package com.caregiver.Caregiver.Tracker.System.repository;


import com.caregiver.Caregiver.Tracker.System.model.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {
}
