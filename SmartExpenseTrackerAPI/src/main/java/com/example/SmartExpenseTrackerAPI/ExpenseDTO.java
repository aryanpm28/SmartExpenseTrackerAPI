package com.example.SmartExpenseTrackerAPI;

import java.time.LocalDate;

import lombok.Data;

// DTO is used to transfer only required data
@Data
public class ExpenseDTO {
    private String title;
    private double amount;
    private String type;
    private String category;
    private LocalDate date;
}
