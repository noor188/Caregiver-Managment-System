package com.caregiver.Caregiver.Tracker.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PatientID")
    private Integer patientID;

    @NotNull
    @NotBlank(message = "first name is required")
    @Column(name = "First Name")
    private String firstName;

    @NotNull
    @NotBlank(message = "last name is required")
    @Column(name = "Last Name")
    private String lastName;

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


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientID == patient.patientID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patientID);
    }

}
