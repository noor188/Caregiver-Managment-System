package com.caregiver.Caregiver.Tracker.System.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Data
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preferenceId")
    private Long preferenceId;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String culturalConsiderations;
    private String specialCareRequirements;

    @OneToOne(mappedBy = "preference")
    private Patient patient;

    @OneToOne(mappedBy = "preference")
    private Caregiver caregiver;

    public Long getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(Long preferenceId) {
        this.preferenceId = preferenceId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCulturalConsiderations() {
        return culturalConsiderations;
    }

    public void setCulturalConsiderations(String culturalConsiderations) {
        this.culturalConsiderations = culturalConsiderations;
    }

    public String getSpecialCareRequirements() {
        return specialCareRequirements;
    }

    public void setSpecialCareRequirements(String specialCareRequirements) {
        this.specialCareRequirements = specialCareRequirements;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
}
