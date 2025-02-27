package com.example.GreetingApp.service;

import com.example.GreetingApp.entity.GreetingEntity;
import com.example.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Returns a default greeting message
    public String getGreetingMessage() {
        return "Hello World";
    }

    // Saves a greeting message to the database
    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }

    // Retrieves a greeting by its ID
    public GreetingEntity getMessageById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    // Retrieves all greetings
    public List<GreetingEntity> getAllMessage() {
        return greetingRepository.findAll();
    }
}
