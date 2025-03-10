package com.caregiver.Caregiver.Tracker.System.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin extends BaseUser{

    public Admin(){
    }

}
