package com.caregiver.Caregiver.Tracker.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Caregiver extends BaseUser{

    @NotNull
    @NotBlank(message = "age is required")
    @Column(name = "Age")
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Enumerated(EnumType.STRING)  // Store role as a string in the database
    private Role role;

    @ManyToMany(mappedBy = "caregivers", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Patient> patients = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferenceId")
    private Preference preference;

    public Caregiver(){
        super();
        setRole(Role.CAREGIVER);
    }

    @NotNull
    @NotBlank(message = "age is required")
    public int getAge() {
        return age;
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }
}
