package com.assignment.service;

import org.springframework.stereotype.Service;

@Service
public class TimerService {

    private long startTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public long stopTimer() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        startTime = 0; // Reset the start time
        return elapsedTime;
    }
}
