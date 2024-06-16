package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;


//TASK 2: ADD MAPPED-SUPERCLASS
@MappedSuperclass
public abstract class AbstractEntity {

    //TASK 2: ADD ID/GENERATED VALUE
    @Id
    @GeneratedValue
    private int id;

    //TASK 2: ADD VALIDATION
    //CANNOT BE EMPTY - LENGTH LIMITATIONS
    @NotBlank(message = "Name required")
    @Size(min = 1, max = 100, message = "Name between 1 and 100 characters")
    private String name;


    //GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
