package com.example.GreetingApp.dto;

public class GreetingRequest {
    private String firstName;
    private String lastName;

    // Constructors
    public GreetingRequest() {}

    public GreetingRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter and setter method
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
