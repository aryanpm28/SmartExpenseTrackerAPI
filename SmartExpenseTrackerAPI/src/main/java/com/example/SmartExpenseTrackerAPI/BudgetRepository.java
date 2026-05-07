package com.example.SmartExpenseTrackerAPI;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository for Budget table
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Budget findByCategoryAndMonthAndYear(String category, int month, int year);
}
