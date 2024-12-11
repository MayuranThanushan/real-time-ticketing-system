package org.example.ticketingsystem.service;

public class TicketPool {
    private int availableTickets;  // Keeps track of the number of available tickets
    private final int maxCapacity;  // Maximum capacity of tickets in the pool

    // Constructor to initialize the ticket pool with a max capacity
    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;  // Set the maximum capacity of the pool
        this.availableTickets = 0;  // Initialize the available tickets to 0
    }

    // Returns the current available tickets in the pool
    public synchronized int getAvailableTickets() {
        return availableTickets;  // Return the current number of available tickets
    }

    // Adds tickets to the pool without exceeding the maximum capacity
    public synchronized void addTickets(int ticketsToAdd) {
        // Ensure the number of tickets added does not exceed the max capacity
        availableTickets = Math.min(availableTickets + ticketsToAdd, maxCapacity);  // Add tickets while respecting the max capacity
    }

    // Removes a ticket from the pool if available
    public synchronized void removeTicket() {
        if (availableTickets > 0) {  // Check if there are any available tickets to remove
            availableTickets--;  // Decrement the available tickets
        } else {
            throw new IllegalStateException("No tickets available to remove.");  // Throw an exception if no tickets are left
        }
    }
}
