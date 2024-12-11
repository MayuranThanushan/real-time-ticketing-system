package org.example.ticketingsystem.model;

public class Configuration {
    // Field to store the total number of tickets
    private int totalTickets;

    // Field to store the rate at which tickets are released (e.g., per minute or hour)
    private int ticketReleaseRate;

    // Field to store the rate at which customers retrieve tickets (e.g., per minute or hour)
    private int customerRetrievalRate;

    // Field to store the maximum capacity of tickets that can be handled
    private int maxTicketCapacity;

    // Getter for totalTickets
    public int getTotalTickets() {
        return totalTickets;  // Returns the total number of tickets
    }

    // Setter for totalTickets
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;  // Sets the total number of tickets
    }

    // Getter for ticketReleaseRate
    public int getTicketReleaseRate() {
        return ticketReleaseRate;  // Returns the rate at which tickets are released
    }

    // Setter for ticketReleaseRate
    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;  // Sets the rate at which tickets are released
    }

    // Getter for customerRetrievalRate
    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;  // Returns the rate at which customers retrieve tickets
    }

    // Setter for customerRetrievalRate
    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;  // Sets the rate at which customers retrieve tickets
    }

    // Getter for maxTicketCapacity
    public int getMaxTicketCapacity() {
        return maxTicketCapacity;  // Returns the maximum ticket capacity
    }

    // Setter for maxTicketCapacity
    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;  // Sets the maximum ticket capacity
    }
}
