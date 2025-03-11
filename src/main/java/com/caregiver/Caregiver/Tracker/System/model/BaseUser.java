package com.caregiver.Caregiver.Tracker.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "first name is required")
    @Column(name = "First Name")
    private String firstName;

    @NotNull
    @NotBlank(message = "last name is required")
    @Column(name = "Last Name")
    private String lastName;

    @NotNull
    @NotBlank(message = "email is required")
    @Size(min = 3, max = 50, message = "email must be between 3 and 50 characters")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank(message = "first name is required") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @NotBlank(message = "first name is required") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @NotBlank(message = "last name is required") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @NotBlank(message = "last name is required") String lastName) {
        this.lastName = lastName;
    }

    public @NotNull @NotBlank(message = "email is required") @Size(min = 3, max = 50, message = "email must be between 3 and 50 characters") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @NotBlank(message = "email is required") @Size(min = 3, max = 50, message = "email must be between 3 and 50 characters") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
