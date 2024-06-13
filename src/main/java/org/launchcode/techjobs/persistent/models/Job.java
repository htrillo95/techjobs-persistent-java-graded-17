package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.List;

//EXTENDS
@Entity
public class Job extends AbstractEntity{

    //MANY-TO-ONE RELATIONSHIP
    @ManyToOne
    private Employer employer;

    //SKILLS FIELD
    private String skills;

    public Job() {
    }

    //ID & VALUES FIELD
    public Job(Employer anEmployer, String someSkills) { //REFACTOR employer -> Employer
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    //GETTERS & SETTERS
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
