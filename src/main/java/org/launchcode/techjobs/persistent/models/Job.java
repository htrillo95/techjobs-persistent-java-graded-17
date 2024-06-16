package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

//TASK 3
//EXTENDS
@Entity
public class Job extends AbstractEntity{


    //MANY-TO-ONE RELATIONSHIP
    @ManyToOne
    private Employer employer;


    //-------------------------------------------------


    //TASK 4
    //PREVIOUSLY: private String skills;
    //CHANGE TO List<Skill>
    //ANNOTATE @ManyToMany
    @ManyToMany
    private List<Skill> skills = new ArrayList<>();


    public Job() {
    }

    //TASK 4
    //PREVIOUS ID & VALUES FIELD
    //UPDATE TO LIST OF SKILLS
    public Job(Employer anEmployer, List<Skill> someSkills) { //REFACTOR employer -> Employer
        super();                                             //String Skill -> List<Skill>
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    //GETTERS & SETTERS FOR EMPLOYER - UPDATED
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }


    //UPDATED GETTER & SETTERS FOR SKILLS
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
