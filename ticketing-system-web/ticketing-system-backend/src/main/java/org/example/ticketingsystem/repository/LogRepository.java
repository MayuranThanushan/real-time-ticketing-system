package org.example.ticketingsystem.repository;

import org.example.ticketingsystem.entity.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for LogEntry entity, extending JpaRepository
public interface LogRepository extends JpaRepository<LogEntry, Long> {
    // JpaRepository provides basic CRUD operations, including save(), findAll(), findById(), delete(), etc.
}
