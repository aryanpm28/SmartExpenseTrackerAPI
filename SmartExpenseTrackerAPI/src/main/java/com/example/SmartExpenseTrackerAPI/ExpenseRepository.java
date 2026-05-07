package com.example.SmartExpenseTrackerAPI;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository handles database operations
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
