package com.caregiver.Caregiver.Tracker.System.service;

import com.caregiver.Caregiver.Tracker.System.model.Preference;
import com.caregiver.Caregiver.Tracker.System.repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    public List<Preference> getAllPreferences(){
        return preferenceRepository.findAll();
    }

    public Optional<Preference> getPreferenceById(Long id){
        return preferenceRepository.findById(id);
    }

    public Preference savePreference(Preference preference){
        return preferenceRepository.save(preference);
    }

    public void deletePreference(Long id){
        preferenceRepository.deleteById(id);
    }
}
