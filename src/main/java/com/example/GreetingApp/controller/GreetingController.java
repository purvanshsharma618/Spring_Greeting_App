package com.example.GreetingApp.controller;

import com.example.GreetingApp.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage());
        return ResponseEntity.ok(response);
    }
}