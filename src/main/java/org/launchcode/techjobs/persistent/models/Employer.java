package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//TASK 2: ADD ENTITY ANNOTATION/EXTENDS
@Entity
public class Employer extends AbstractEntity {

    //NOT-BLANK/SIZE ANNOTATIONS EXTEND
    @NotBlank(message = "Location is required")
    @Size(max = 100, message = "Location must be 100 characters or less")
    private String location;

    //NO-ARG CONSTRUCTOR
    public Employer() {}

    //GETTER & SETTER
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

