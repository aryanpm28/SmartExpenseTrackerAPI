package com.example.SmartExpenseTrackerAPI;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    @Autowired
    private BudgetRepository budgetRepo;

    // ADD EXPENSE
    public String addExpense(ExpenseDTO dto) {

        Expense expense = new Expense();

        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setType(dto.getType());
        expense.setCategory(dto.getCategory());
        expense.setDate(LocalDate.now());

        repo.save(expense);

        checkBudgetExceeded(dto);

        return "Expense added successfully";
    }

    // UPDATE EXPENSE
    public Expense updateExpense(Long id, ExpenseDTO dto) {

        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Expense expense = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setType(dto.getType());
        expense.setCategory(dto.getCategory());

        return repo.save(expense);
    }

    // DELETE EXPENSE
    public String deleteExpense(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Expense expense = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

        repo.delete(expense);

        return "Expense deleted successfully";
    }

    // GET ALL EXPENSES
    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    public List<Expense> getAll() {
        return repo.findAll();
    }

    // GET EXPENSE BY ID
    public Expense getExpenseById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
    }

    // GET TOTAL INCOME
    public double getTotalIncome() {

        return repo.findAll().stream()
                .filter(e -> e.getType().equalsIgnoreCase("INCOME"))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // GET TOTAL EXPENSE
    public double getTotalExpense() {

        return repo.findAll().stream()
                .filter(e -> e.getType().equalsIgnoreCase("EXPENSE"))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // GET BALANCE
    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    // SEARCH BY CATEGORY
    public List<Expense> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    // PAGINATION
    public Page<Expense> getExpensesWithPagination(int page, int size) {

        return repo.findAll(PageRequest.of(page, size));
    }

    // CHECK BUDGET
    private void checkBudgetExceeded(ExpenseDTO dto) {

        int month = LocalDate.now().getMonthValue();
        int year = LocalDate.now().getYear();

        Budget budget = budgetRepo.findByCategoryAndMonthAndYear(
                dto.getCategory(),
                month,
                year);

        if (budget != null &&
                dto.getType().equalsIgnoreCase("EXPENSE")) {

            double totalSpent = repo.findAll().stream()
                    .filter(e -> e.getCategory()
                            .equalsIgnoreCase(dto.getCategory()))
                    .filter(e -> e.getDate()
                            .getMonthValue() == month)
                    .filter(e -> e.getType()
                            .equalsIgnoreCase("EXPENSE"))
                    .mapToDouble(Expense::getAmount)
                    .sum();

            if (totalSpent > budget.getAmount()) {

                System.out.println(
                        "WARNING: Budget exceeded for "
                                + dto.getCategory());
            }
        }
    }
}