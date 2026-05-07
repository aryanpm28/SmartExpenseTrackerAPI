package com.example.SmartExpenseTrackerAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// Creates Budget table in database
@Entity
@Data
public class Budget {
    
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto generated ID

    private String category;
    
    // Monthly budget amount
    private double amount;

    private int month;
    private int year;

}
