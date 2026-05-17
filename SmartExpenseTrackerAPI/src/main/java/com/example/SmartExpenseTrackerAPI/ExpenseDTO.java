package com.example.SmartExpenseTrackerAPI;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

// DTO is used to transfer only required data
@Data
public class ExpenseDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    private String type;

    private String category;

    private LocalDate date;
}
