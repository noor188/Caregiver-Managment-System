package com.caregiver.Caregiver.Tracker.System.repository;

import com.caregiver.Caregiver.Tracker.System.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface baseUserRepository extends JpaRepository<BaseUser, Long> {
    Optional<BaseUser> findByEmail(String email);
}
