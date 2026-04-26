package com.expense.expense_tracker;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private List<Expense> expenses = new ArrayList<>();
    private int idCounter = 1;

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public void addExpense(Expense expense) {
        expense.setId(idCounter++);
        expenses.add(expense);
    }

    public void deleteExpense(int id) {
        expenses.removeIf(e -> e.getId() == id);
    }

    public double getTotalAmount() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> filtered = new ArrayList<>();
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                filtered.add(e);
            }
        }
        return filtered;
    }
}