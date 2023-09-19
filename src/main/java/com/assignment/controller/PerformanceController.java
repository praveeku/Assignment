package com.assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.service.TimerService;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    private TimerService timerService;

    @PostMapping("/startTimer")
    public ResponseEntity<String> startTimer(@RequestParam("digits") String digits) {
        // Validate that the input contains only digits
        if (!digits.matches("\\d+")) {
            return ResponseEntity.badRequest().body("Input should contain only digits.");
        }

        // Start the timer
        timerService.startTimer();

        // Make API request using the provided digits
        // Assume you have an API service to handle the request
        // Example API service usage: apiService.sendRequest(digits);

        // Return a success message
        return ResponseEntity.ok("Timer started. Sending API request with digits: " + digits);
    }

    @GetMapping("/stopTimer")
    public ResponseEntity<String> stopTimer() {
        // Stop the timer
        long elapsedTimeInMillis = timerService.stopTimer();

        // Assume API response received successfully (HTTP 200 OK)
        // Log the elapsed time
        System.out.println("API Response received in " + elapsedTimeInMillis + " milliseconds.");

        // Return a success message
        return ResponseEntity.ok("Timer stopped. API response received in " + elapsedTimeInMillis + " milliseconds.");
    }
}
