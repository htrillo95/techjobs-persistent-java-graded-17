package org.launchcode.techjobs.persistent.models;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

//TASK 2: ADD ENTITY ANNOTATION/EXTENDS
@Entity
public class Skill extends AbstractEntity {


    //DESCRIPTION FIELD
    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description must be 255 characters or less")
    private String description;


    //NO-ARG CONSTRUCTOR
    public Skill() {}

    // GETTER & SETTER
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    //TASK 4
    //ADD JOB FIELD
    //MANY-TO-MANY
    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();

    //GETTER & SETTER
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;

    }

}
