package org.example.ticketingsystem.controller;

import org.example.ticketingsystem.service.TicketService;
import org.example.ticketingsystem.service.LogService;
import org.springframework.web.bind.annotation.*;

@RestController  // This annotation defines the class as a RESTful web service controller
@RequestMapping("/api/database")  // Maps HTTP requests to this controller at the "/api/database" URL path
public class DatabaseController {

    private final TicketService ticketService;  // Service for ticket-related operations
    private final LogService logService;        // Service for log-related operations

    // Constructor to inject dependencies for TicketService and LogService
    public DatabaseController(TicketService ticketService, LogService logService) {
        this.ticketService = ticketService;
        this.logService = logService;
    }

    /**
     * Resets the entire database by deleting all tickets and clearing logs.
     *
     * @return A message indicating that the database has been reset.
     */
    @DeleteMapping("/reset")  // Maps DELETE requests to "/api/database/reset"
    public String resetDatabase() {
        ticketService.deleteAllTickets();  // Calls the method in TicketService to delete all tickets from the database
        logService.clearLogs();  // Calls the method in LogService to clear all logs from the database
        return "Database reset successfully.";  // Returns a success message after resetting the database
    }
}
