package com.example.GreetingApp.service;

import com.example.GreetingApp.entity.GreetingEntity;
import com.example.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;
    public String getGreetingMessage() {
        return "Hello World";
    }
    //Method to create and save a greeting message
    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }public GreetingEntity getMessageById(long id) {
        return greetingRepository.findById(id).orElse(null);
    }
    public List<GreetingEntity> getAllMessage(){
        return greetingRepository.findAll();
    }
    public String getGreeting() {
        return "Hello World";
    }
}
