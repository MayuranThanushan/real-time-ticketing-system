package org.example.ticketingsystem.service;

import org.example.ticketingsystem.entity.LogEntry;
import org.example.ticketingsystem.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service  // Indicates that this is a service class that handles business logic
public class LogService {

    private final LogRepository logRepository;  // Dependency injection for the LogRepository

    // Constructor for dependency injection of LogRepository
    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    // Method to save a log action to the database
    public void logAction(String action, String details) {
        LogEntry log = new LogEntry();  // Create a new LogEntry object
        log.setAction(action);  // Set the action of the log
        log.setDetails(details);  // Set the details of the log
        log.setTimestamp(LocalDateTime.now());  // Set the current timestamp for the log
        logRepository.save(log);  // Save the log entry to the database using the repository
    }

    // Method to fetch logs with pagination
    public List<LogEntry> getLogs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  // Create a Pageable object with the requested page number and size
        Page<LogEntry> logPage = logRepository.findAll(pageable);  // Fetch the logs with pagination
        return logPage.getContent();  // Return the content (logs) from the page as a list
    }

    // Method to fetch all logs without pagination
    public List<LogEntry> getLogs() {
        return logRepository.findAll();  // Retrieve all logs from the repository (no pagination)
    }

    // Method to clear all logs from the database
    public void clearLogs() {
        logRepository.deleteAll();  // Delete all records from the LogEntry table in the database
    }
}
