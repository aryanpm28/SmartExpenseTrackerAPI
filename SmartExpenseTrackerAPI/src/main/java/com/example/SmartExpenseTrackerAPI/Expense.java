package com.example.SmartExpenseTrackerAPI;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Marks this class as a database table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Expense title
    @NotBlank(message = "Title is required")
    private String title;

    // Expense amount
    @Positive(message = "Amount must be greater than 0")
    private double amount;

    // INCOME or EXPENSE
    @NotBlank(message = "Type is required")
    private String type;

    // Food, Travel, Shopping etc.
    @NotBlank(message = "Category is required")
    private String category;

    // Expense date
    @NotNull(message = "Date is required")
    private LocalDate date;
}