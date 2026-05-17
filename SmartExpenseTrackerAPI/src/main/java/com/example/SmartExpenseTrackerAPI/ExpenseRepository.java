package com.example.SmartExpenseTrackerAPI;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository handles database operations
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    List<Expense> findByCategory(String category);
}
