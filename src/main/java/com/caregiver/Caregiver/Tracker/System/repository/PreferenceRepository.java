package com.caregiver.Caregiver.Tracker.System.repository;

import com.caregiver.Caregiver.Tracker.System.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
