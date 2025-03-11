package com.caregiver.Caregiver.Tracker.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Patient extends BaseUser{

    @NotNull
    @NotBlank(message = "age is required")
    @Column(name = "Age")
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Language language;


    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "patient-caregiver",
            joinColumns = @JoinColumn(name = "PatientID"),
            inverseJoinColumns = @JoinColumn(name = "CaregiverID")
    )
    private Set<Caregiver> caregivers = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "preferenceId")
    private Preference preference;

    @NotNull
    @NotBlank(message = "age is required")
    public int getAge() {
        return age;
    }

    public Patient(){
        super();
        setRole(Role.PATIENT);
    }

    public void setAge(@NotNull @NotBlank(message = "age is required") int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<Caregiver> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(Set<Caregiver> caregivers) {
        this.caregivers = caregivers;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }



}
