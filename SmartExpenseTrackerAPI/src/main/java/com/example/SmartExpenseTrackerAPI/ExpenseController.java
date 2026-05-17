package com.example.SmartExpenseTrackerAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

// REST API Controller
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    // Inject Expense Service
    @Autowired
    private ExpenseService service;

    // Inject Budget Repository
    @Autowired
    private BudgetRepository budgetRepo;

    // Home API
    @GetMapping("/")
    public String home() {
        return "Smart Expense Tracker API is Running";
    }

    // Add Expense
    @PostMapping
    public String addExpense(@Valid @RequestBody ExpenseDTO dto) {
        return service.addExpense(dto);
    }

    // Get All Expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAll();
    }

    // Get Expense By ID
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return service.getExpenseById(id);
    }

    // Update Expense
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,
            @RequestBody ExpenseDTO dto) {

        return service.updateExpense(id, dto);
    }

    // Delete Expense
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        return service.deleteExpense(id);
    }

    // Get Total Income
    @GetMapping("/income")
    public double getTotalIncome() {
        return service.getTotalIncome();
    }

    // Get Total Expense
    @GetMapping("/expense")
    public double getTotalExpense() {
        return service.getTotalExpense();
    }

    // Get Current Balance
    @GetMapping("/balance")
    public double getBalance() {
        return service.getBalance();
    }

    // Add Budget
    @PostMapping("/budget")
    public Budget addBudget(@RequestBody Budget budget) {

        return budgetRepo.save(budget);
    }

    // Search Expense By Category
    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category) {

        return service.getByCategory(category);
    }

    // Pagination API
    @GetMapping("/pagination")
    public Page<Expense> pagination(@RequestParam int page,
            @RequestParam int size) {

        return service.getExpensesWithPagination(page, size);
    }
}