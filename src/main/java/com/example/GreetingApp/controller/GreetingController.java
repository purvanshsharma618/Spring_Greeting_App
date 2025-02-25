package com.example.GreetingApp.controller;

import com.example.GreetingApp.dto.GreetingDTO;
import com.example.GreetingApp.dto.GreetingRequest;
import com.example.GreetingApp.entity.GreetingEntity;
import com.example.GreetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    //UC1
    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from GET method!");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/uc1")
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

    //UC2

    private final GreetingService greetingService;

    // Constructor Injection
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/uc2")
    public ResponseEntity<Map<String, String>> getGreetings() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage());
        return ResponseEntity.ok(response);
    }

    //UC3
      @PostMapping
     public ResponseEntity<Map<String, String>> postGreetings(@RequestBody GreetingRequest greetingRequest) {
      Map<String, String> response = new HashMap<>();
       response.put("Message", "Hello " + greetingRequest.getFirstName()+ " " + greetingRequest.getLastName());
        return ResponseEntity.ok(response);
   }


   //UC-04
   @PostMapping("/add")
   public GreetingEntity greeting(@RequestBody GreetingDTO greetingDTO){
       return greetingService.saveGreeting(greetingDTO.getMessage());
   }



}