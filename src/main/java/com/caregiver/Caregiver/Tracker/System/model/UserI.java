package com.caregiver.Caregiver.Tracker.System.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface UserI {

    Role getRole();

    String getPassword();

    String getEmail();
}
