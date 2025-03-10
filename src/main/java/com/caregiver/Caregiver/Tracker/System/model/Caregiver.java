package com.caregiver.Caregiver.Tracker.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@Data
public class Caregiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CaregiverID")
    private Integer caregiverID;

    @NotNull
    @NotBlank(message = "first name is required")
    @Column(name = "FirstName")
    private String firstName;

    @NotNull
    @NotBlank(message = "last name is required")
    @Column(name = "LastName")
    private String lastName;

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

    @ManyToMany(mappedBy = "caregivers", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Patient> patients = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferenceId")
    private Preference preference;


    public Integer getCaregiverID() {
        return caregiverID;
    }

    public void setCaregiverID(Integer caregiverID) {
        this.caregiverID = caregiverID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caregiver caregiver = (Caregiver) o;
        return caregiverID == caregiver.caregiverID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(caregiverID);
    }
}
