package com.restfull.service.project.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class updateUserModel {

    String id;

    @NotEmpty (message = "Name-field should not be empty")
    @Size (min = 2, max = 60, message = "Name-size should at least be 2 characters with a maximum of 60")
    String name;

    @NotEmpty (message = "Lastname-field should not be empty")
    @Size (min = 2, max = 120, message = "Name-size should at least be 2 characters with a maximum of 120")
    String lastName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
