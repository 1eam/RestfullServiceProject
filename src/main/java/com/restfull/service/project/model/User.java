package com.restfull.service.project.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotEmpty(message = "Name-field should not be empty")
    @Size(min = 2, max = 60, message = "Size should at least have 2 characters with a maximum of 60")
    String name;

    @NotEmpty (message = "Lastname-field should not be empty")
    String lastName;

    @NotEmpty (message = "Email-field should not be empty")
    @Email (message = "You must enter a valid email-address")
    String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
