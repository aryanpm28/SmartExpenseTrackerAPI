package com.example.SmartExpenseTrackerAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REST API controller
@RestController
@RequestMapping("/expenses") // Base URL
public class ExpenseController {

    // Inject service object
    @Autowired
    private ExpenseService service;

    // Inject service object
    @Autowired
    private BudgetRepository budgetRepo;

    // API to add expense
    @PostMapping
    public String add(@RequestBody ExpenseDTO dto) {
        return service.addExpense(dto);
    }

    // API to delete expense by ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteExpense(id);
    }

    // API to get all expenses
    @GetMapping
    public List<Expense> getAll() {
        return service.getAll();
    }

    // API to get expense by ID
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {

        return service.getExpenseById(id);
    }

    @GetMapping("/")
    public String home() {
        return "Expense Tracker API is running";
    }

    // API to get all total income by ID
    @GetMapping("/income")
    public double income() {
        return service.getTotalIncome();
    }

    // API to get all total expense by ID
    @GetMapping("/expense")
    public double expense() {
        return service.getTotalExpense();
    }

    // API to get all balance by ID
    @GetMapping("/balance")
    public double balence() {
        return service.getBalance();
    }

    // API to get all budget by ID
    @PostMapping("/budget")
    public Budget addBudget(@RequestBody Budget budget) {
        return budgetRepo.save(budget);
    }
}
