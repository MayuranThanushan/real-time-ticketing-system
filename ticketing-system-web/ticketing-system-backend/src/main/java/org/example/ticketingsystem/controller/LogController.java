package org.example.ticketingsystem.controller;

import org.example.ticketingsystem.entity.LogEntry;
import org.example.ticketingsystem.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Marks this class as a RESTful web service controller
@RequestMapping("/api/logs")  // Maps HTTP requests to this controller at the "/api/logs" URL path
public class LogController {
    private final LogService logService;  // Service for handling log-related operations

    // Constructor to inject the LogService dependency
    public LogController(LogService logService) {
        this.logService = logService;
    }

    /**
     * Endpoint to fetch all logs.
     *
     * @return A list of LogEntry objects containing the logs.
     */
    @GetMapping  // Maps GET requests to "/api/logs" to this method
    public List<LogEntry> getLogs() {
        try {
            return logService.getLogs();  // Fetches all logs from the LogService
        } catch (Exception e) {
            // Log error and return an empty list or an appropriate error response
            System.out.println("Error fetching logs: " + e.getMessage());
            return List.of();  // Returns an empty list in case of an error
        }
    }
}
