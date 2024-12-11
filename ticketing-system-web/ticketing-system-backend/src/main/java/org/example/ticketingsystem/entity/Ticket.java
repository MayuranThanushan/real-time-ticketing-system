package org.example.ticketingsystem.entity;

import jakarta.persistence.*;  // Importing JPA annotations for entity mapping
import java.time.LocalDateTime;  // Importing LocalDateTime for handling date and time

@Entity  // Marks this class as a JPA entity to be mapped to a database table
public class Ticket {

    @Id  // Marks this field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the primary key value (auto-incremented)
    private Long id;  // Unique identifier for each ticket

    private String name;  // The name or description of the ticket

    private LocalDateTime createdAt;  // The timestamp of when the ticket was created

    private String status;  // The current status of the ticket (e.g., "Open", "Closed")

    // No-argument constructor required by JPA
    public Ticket() {
    }

    // Constructor with all fields (used for creating a ticket with all necessary data)
    public Ticket(Long id, String name, LocalDateTime createdAt, String status) {
        this.id = id;  // Initialize the id field
        this.name = name;  // Initialize the name field
        this.createdAt = createdAt;  // Initialize the createdAt field
        this.status = status;  // Initialize the status field
    }

    // Getter for id
    public Long getId() {
        return id;  // Returns the id of the ticket
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;  // Sets the id for the ticket
    }

    // Getter for name
    public String getName() {
        return name;  // Returns the name/description of the ticket
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;  // Sets the name/description of the ticket
    }

    // Getter for createdAt
    public LocalDateTime getCreatedAt() {
        return createdAt;  // Returns the timestamp when the ticket was created
    }

    // Setter for createdAt
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;  // Sets the timestamp for when the ticket was created
    }

    // Getter for status
    public String getStatus() {
        return status;  // Returns the current status of the ticket (e.g., "Open", "Closed")
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;  // Sets the current status of the ticket
    }

    // Optional: Override toString() method for better logging or debugging
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +  // Include the ticket's id in the string representation
                ", name='" + name + '\'' +  // Include the name/description of the ticket
                ", createdAt=" + createdAt +  // Include the created timestamp of the ticket
                ", status='" + status + '\'' +  // Include the status of the ticket
                '}';  // Return a string representation of the ticket object
    }
}
