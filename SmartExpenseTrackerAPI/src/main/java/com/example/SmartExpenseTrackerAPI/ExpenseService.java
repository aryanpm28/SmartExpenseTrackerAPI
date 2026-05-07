package com.example.SmartExpenseTrackerAPI;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service layer contains business logic
@Service
public class ExpenseService {

    // Inject repository object
    @Autowired
    private ExpenseRepository repo;

    // Inject repository object
    @Autowired
    private BudgetRepository budgetRepo;

    // Save expense into database
    public String addExpense(ExpenseDTO dto) {
        Expense expense = new Expense();

        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setType(dto.getType());
        expense.setCategory(dto.getCategory());
        expense.setDate(LocalDate.now());

        repo.save(expense);

        int month = LocalDate.now().getMonthValue();
        int year = LocalDate.now().getYear();

        Budget budget = budgetRepo.findByCategoryAndMonthAndYear(
                dto.getCategory(), month, year);

        if (budget != null && dto.getType().equalsIgnoreCase("EXPENSE")) {

            double totalSpent = repo.findAll().stream()
                    .filter(e -> e.getCategory().equals(dto.getCategory()))
                    .filter(e -> e.getDate().getMonthValue() == month)
                    .filter(e -> e.getType().equalsIgnoreCase("EXPENSE"))
                    .mapToDouble(Expense::getAmount)
                    .sum();

            if (totalSpent > budget.getAmount()) {
                return "Budget exceeded for " + dto.getCategory();
            }
        }

        return "Expense added successfully";
    }

    // Delete expense by ID
    public String deleteExpense(Long id) {

        Expense expense = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        repo.delete(expense);

        return "Expense deleted successfully";

    }

    // Get all expenses from database
    public List<Expense> getAll() {
        return repo.findAll();
    }

    // Get expense by ID
    public Expense getExpenseById(Long id) {

        return repo.findById(id).orElse(null);
    }

    // Get all expenses income
    public double getTotalIncome() {
        return repo.findAll().stream()
                .filter(e -> e.getType().equalsIgnoreCase("INCOME"))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // Get all expenses total expense
    public double getTotalExpense() {
        return repo.findAll().stream()
                .filter(e -> e.getType().equalsIgnoreCase("EXPENSE"))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // Get all expenses balance
    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }
}
