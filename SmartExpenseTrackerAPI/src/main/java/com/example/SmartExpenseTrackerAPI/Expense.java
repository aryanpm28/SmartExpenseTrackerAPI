package com.example.SmartExpenseTrackerAPI;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// Marks this class as a database table
@Entity
@Data
public class Expense {

    // Primary key of table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto increment ID

    // Name of expense
    private String title;

    // Amount spent
    private double amount;

    private String type;

    // Expense category
    private String category;

    // Date of expense
    private LocalDate date;
}
