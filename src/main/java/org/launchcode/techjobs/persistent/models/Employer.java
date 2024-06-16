package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;

//TASK 2: ADD ENTITY ANNOTATION/EXTENDS
@Entity
public class Employer extends AbstractEntity {

    //VALIDATION & LENGTH LIMITATION
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


// ---------------------------------------

    //TASK 3: ADD JOBS FIELD
    @OneToMany
    @JoinColumn(name = "employer_id") //PARAM
    private List<Job> jobs = new ArrayList<>(); //INITIALIZE TO EMPTY ARRAYLIST

    //GETTER & SETTER
    public List<Job> getJobs() {
        return jobs;
    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }


}

