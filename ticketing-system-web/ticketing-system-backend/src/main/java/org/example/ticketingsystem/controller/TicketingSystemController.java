package org.example.ticketingsystem.controller;

import org.example.ticketingsystem.dto.ConfigDTO;
import org.example.ticketingsystem.model.Configuration;
import org.example.ticketingsystem.service.LogService;
import org.example.ticketingsystem.service.TicketPool;
import org.springframework.web.bind.annotation.*;

@RestController  // Marks this class as a RESTful web service controller
@RequestMapping("/api")  // Maps HTTP requests to this controller at the "/api" URL path
public class TicketingSystemController {

    private Configuration configuration;  // Holds the system's configuration
    private TicketPool ticketPool;  // Manages the pool of tickets
    private boolean isSystemRunning = false;  // Tracks whether the system is running or not
    private final LogService logService;  // Logs actions taken in the system

    // Constructor injection for LogService
    public TicketingSystemController(LogService logService) {
        this.logService = logService;
    }

    /**
     * Save the system configuration received from the client.
     *
     * @param configDTO Configuration details.
     * @return Success message indicating that the configuration was saved.
     */
    @PostMapping("/config")  // Maps POST requests to "/api/config" to this method
    public String saveConfig(@RequestBody ConfigDTO configDTO) {
        // Save the configuration settings
        this.configuration = new Configuration();
        configuration.setTotalTickets(configDTO.getTotalTickets());
        configuration.setTicketReleaseRate(configDTO.getTicketReleaseRate());
        configuration.setCustomerRetrievalRate(configDTO.getCustomerRetrievalRate());
        configuration.setMaxTicketCapacity(configDTO.getMaxTicketCapacity());

        // Initialize the ticket pool with the maximum ticket capacity and add tickets
        this.ticketPool = new TicketPool(configuration.getMaxTicketCapacity());
        ticketPool.addTickets(configuration.getTotalTickets());  // Add the total number of tickets

        return "Configuration saved successfully!";  // Confirmation message
    }

    /**
     * Fetch the current system status, including the number of available tickets and system running status.
     *
     * @return The current status of the ticket system.
     */
    @GetMapping("/status")  // Maps GET requests to "/api/status" to this method
    public Status getStatus() {
        // Ensure that the ticket pool is initialized
        if (ticketPool == null) {
            throw new IllegalStateException("Ticket pool is not initialized. Save the configuration first by calling /api/config.");
        }

        // Create and return a status object with available tickets and system running status
        Status status = new Status();
        status.setAvailableTickets(ticketPool.getAvailableTickets());
        status.setRunning(isSystemRunning);
        return status;
    }

    /**
     * Start the ticketing system by initializing threads for vendors and customers.
     *
     * @return A message indicating the status of the system (started or already running).
     */
    @PostMapping("/start")  // Maps POST requests to "/api/start" to this method
    public String startSystem() {
        // Ensure the ticket pool is initialized before starting the system
        if (ticketPool == null) {
            return "Ticket pool is not initialized. Please call /api/config first.";
        }

        // Start the system if it is not already running
        if (!isSystemRunning) {
            isSystemRunning = true;
            new Thread(new VendorRunnable()).start();  // Start vendor thread to release tickets
            new Thread(new CustomerRunnable()).start();  // Start customer thread to buy tickets
            logService.logAction("System Start", "The system has started successfully.");
            return "System started";
        }
        return "System is already running";  // If the system is already running
    }

    /**
     * Stop the ticketing system.
     *
     * @return A message indicating whether the system was stopped or was not running.
     */
    @PostMapping("/stop")  // Maps POST requests to "/api/stop" to this method
    public String stopSystem() {
        // Stop the system if it is running
        if (isSystemRunning) {
            isSystemRunning = false;
            logService.logAction("System Stopped", "The ticket system has stopped.");
            return "System stopped";
        }
        return "System is not running";  // If the system is not running
    }

    // Status class to hold the current status of the ticket pool
    public static class Status {
        private int availableTickets;  // Number of available tickets in the pool
        private boolean isRunning;  // Indicates whether the system is running

        // Getters and setters for status properties
        public int getAvailableTickets() {
            return availableTickets;
        }

        public void setAvailableTickets(int availableTickets) {
            this.availableTickets = availableTickets;
        }

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean running) {
            isRunning = running;
        }
    }

    // Vendor Thread Runnable to simulate vendors adding tickets to the pool
    public class VendorRunnable implements Runnable {
        private int ticketsReleased = 0;  // Tracks the total number of tickets released by the vendor

        @Override
        public void run() {
            while (isSystemRunning) {
                synchronized (ticketPool) {
                    // If all tickets have been released, stop the vendor thread
                    if (ticketsReleased >= configuration.getTotalTickets()) {
                        logService.logAction("Vendor Halt", "All tickets have been released by the vendor.");
                        break;
                    }

                    // Determine how many tickets to release based on the release rate and available capacity
                    int ticketsToAdd = configuration.getTicketReleaseRate();
                    int currentAvailableTickets = ticketPool.getAvailableTickets();
                    int maxCapacity = configuration.getMaxTicketCapacity();

                    // Ensure the number of tickets doesn't exceed the max capacity
                    if (currentAvailableTickets + ticketsToAdd > maxCapacity) {
                        ticketsToAdd = maxCapacity - currentAvailableTickets;
                    }

                    // Ensure tickets to add does not exceed remaining tickets
                    int remainingTickets = configuration.getTotalTickets() - ticketsReleased;
                    if (ticketsToAdd > remainingTickets) {
                        ticketsToAdd = remainingTickets;
                    }

                    // Add tickets to the pool and update the count
                    if (ticketsToAdd > 0) {
                        ticketPool.addTickets(ticketsToAdd);
                        ticketsReleased += ticketsToAdd;
                        logService.logAction("Vendor Release", " tickets added by vendor.");
                    } else {
                        logService.logAction("Vendor Halt", "No more tickets to release. Vendor is stopping.");
                        break;
                    }
                }

                try {
                    Thread.sleep(1000);  // Wait for a second before releasing more tickets
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Customer Thread Runnable to simulate customers purchasing tickets
    public class CustomerRunnable implements Runnable {
        @Override
        public void run() {
            while (isSystemRunning) {
                synchronized (ticketPool) {
                    // If there are tickets available, a customer buys one
                    if (ticketPool.getAvailableTickets() > 0) {
                        ticketPool.removeTicket();
                        logService.logAction("Ticket Purchased", "A customer bought a ticket.");
                    } else {
                        // If no tickets are left, stop the system
                        logService.logAction("System Stop", "All tickets have been sold. The system is stopping.");
                        isSystemRunning = false;
                        break;
                    }
                }

                try {
                    Thread.sleep(1000);  // Simulate the customer purchase rate (1 second)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
