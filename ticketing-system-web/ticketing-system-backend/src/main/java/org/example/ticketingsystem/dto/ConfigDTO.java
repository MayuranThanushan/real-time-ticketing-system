package org.example.ticketingsystem.dto;

public class ConfigDTO {
    private int totalTickets; // Total number of tickets available in the system
    private int ticketReleaseRate; // Rate at which tickets are released by the vendor (per second)
    private int customerRetrievalRate; // Rate at which customers buy tickets (per second)
    private int maxTicketCapacity; // Maximum capacity of the ticket pool

    // Default constructor
    // This is a no-argument constructor, useful for frameworks like Spring
    public ConfigDTO() {}

    // Constructor with all fields
    // This constructor allows initializing all the fields at once
    public ConfigDTO(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // Getters and Setters
    // These methods allow access and modification of the class fields

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // Override toString method for better string representation
    // This method returns a string representation of the object, which can be helpful for debugging
    @Override
    public String toString() {
        return "ConfigDTO{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }
}
