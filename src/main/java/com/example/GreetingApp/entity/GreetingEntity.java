package com.example.GreetingApp.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "greeting_entity")
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    // Constructors
    public GreetingEntity() {}

    public GreetingEntity(String message) {
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}