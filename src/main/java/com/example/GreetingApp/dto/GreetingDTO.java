package com.example.GreetingApp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.lang.reflect.Type;

public class GreetingDTO {

    private String message;

    // Constructors
    public GreetingDTO() {}

    public GreetingDTO(String message) {

        this.message = message;
    }

    // Getters and Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
}
}