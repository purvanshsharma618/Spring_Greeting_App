package com.example.GreetingApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from GET method!");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> postGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from POST method!");
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from PUT method!");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from DELETE method!");
        return ResponseEntity.ok(response);
    }
}