package com.example.GreetingApp.controller;

import com.example.GreetingApp.dto.GreetingDTO;
import com.example.GreetingApp.dto.GreetingRequest;
import com.example.GreetingApp.entity.GreetingEntity;
import com.example.GreetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC1: Basic HTTP Methods
    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting() {
        return ResponseEntity.ok(Map.of("message", "Hello from GET method!"));
    }

    @PostMapping("/uc1")
    public ResponseEntity<Map<String, String>> postGreeting() {
        return ResponseEntity.ok(Map.of("message", "Hello from POST method!"));
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> putGreeting() {
        return ResponseEntity.ok(Map.of("message", "Hello from PUT method!"));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteGreeting() {
        return ResponseEntity.ok(Map.of("message", "Hello from DELETE method!"));
    }

    // UC2: Service-Driven Greeting
    @GetMapping("/uc2")
    public ResponseEntity<Map<String, String>> getGreetings() {
        return ResponseEntity.ok(Map.of("message", greetingService.getGreetingMessage()));
    }

    // UC3: Personalized Greeting
    @PostMapping("/uc3")
    public ResponseEntity<Map<String, String>> postGreetings(@RequestBody GreetingRequest greetingRequest) {
        String firstName = greetingRequest.getFirstName() != null ? greetingRequest.getFirstName() : "Guest";
        String lastName = greetingRequest.getLastName() != null ? greetingRequest.getLastName() : "";
        return ResponseEntity.ok(Map.of("message", "Hello " + firstName + " " + lastName));
    }

    // UC4: Save Greeting to Database
    @PostMapping("/add")
    public ResponseEntity<GreetingEntity> saveGreeting(@RequestBody GreetingDTO greetingDTO) {
        return ResponseEntity.ok(greetingService.saveGreeting(greetingDTO.getMessage()));
    }

    // UC5: Get Greeting by ID with Exception Handling
    @GetMapping("/{id}")
    public ResponseEntity<String> getGreetingById(@PathVariable long id) {
        GreetingEntity greeting = greetingService.getMessageById(id);
        return ResponseEntity.ok(greeting.getMessage());
    }

    // UC6: Get All Greetings
    @GetMapping("/all")
    public ResponseEntity<List<GreetingEntity>> getAllMessages() {
        return ResponseEntity.ok(greetingService.getAllMessage());
    }

    // UC6 (Alternative Post) - Returns a DTO Instead of Entity
    @PostMapping("/uc6")
    public ResponseEntity<GreetingDTO> createGreeting(@RequestBody GreetingRequest greetingRequest) {
        String fullName = greetingRequest.getFirstName() + " " + greetingRequest.getLastName();
        return ResponseEntity.ok(new GreetingDTO("Hello " + fullName));
    }
}
