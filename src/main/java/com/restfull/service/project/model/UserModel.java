package com.restfull.service.project.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

    String id;

    @NotEmpty (message = "Name-field should not be empty")
    @Size (min = 2, max = 60, message = "Name-size should at least be 2 characters with a maximum of 60")
    String name;

    @NotEmpty (message = "Lastname-field should not be empty")
    @Size (min = 2, max = 120, message = "Name-size should at least be 2 characters with a maximum of 120")
    String lastName;

    @NotEmpty (message = "Email-field should not be empty")
    @Email (message = "You must enter a valid email-address")
    String email;

    @NotNull (message = "Password cannot be empty")
    @Size (min = 8, max = 60, message = "Size should at least have 8 characters with a maximum of 60")
    String password;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
