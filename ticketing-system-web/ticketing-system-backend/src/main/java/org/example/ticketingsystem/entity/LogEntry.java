package org.example.ticketingsystem.entity;

import jakarta.persistence.*;  // Importing JPA annotations
import lombok.Data;  // Lombok annotation to generate getters, setters, toString, etc.

import java.time.LocalDateTime;  // Importing LocalDateTime for timestamp handling

@Data  // Lombok annotation that generates getters, setters, toString, equals, and hashCode methods
@Entity  // Marks this class as a JPA entity to be mapped to a database table
public class LogEntry {

    @Id  // Marks this field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the primary key value (auto-incremented)
    private Long id;  // Unique identifier for each log entry

    private String action;  // The action that triggered the log (e.g., "Ticket Purchased")

    private String details;  // Additional details regarding the action (e.g., "A customer bought a ticket")

    private LocalDateTime timestamp;  // Timestamp for when the log entry was created, capturing the date and time of the action

    // Manual setters and getters (not necessary with Lombok @Data, but included here for explicitness)

    public Long getId() {
        return id;  // Getter for the id field
    }

    public void setId(Long id) {
        this.id = id;  // Setter for the id field
    }

    public String getAction() {
        return action;  // Getter for the action field
    }

    public void setAction(String action) {
        this.action = action;  // Setter for the action field
    }

    public String getDetails() {
        return details;  // Getter for the details field
    }

    public void setDetails(String details) {
        this.details = details;  // Setter for the details field
    }

    public LocalDateTime getTimestamp() {
        return timestamp;  // Getter for the timestamp field
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;  // Setter for the timestamp field
    }
}
