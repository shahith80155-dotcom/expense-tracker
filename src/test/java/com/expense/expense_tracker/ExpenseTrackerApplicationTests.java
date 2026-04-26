package com.expense.expense_tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ExpenseTrackerApplicationTests {

    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseService();
    }

    @Test
    void testAddExpense() {
        Expense expense = new Expense(0, "Food", 100.0,
                "Food", LocalDate.now(), "Lunch");
        expenseService.addExpense(expense);
        assertEquals(1, expenseService.getAllExpenses().size());
    }

    @Test
    void testDeleteExpense() {
        Expense expense = new Expense(0, "Travel", 200.0,
                "Travel", LocalDate.now(), "Bus");
        expenseService.addExpense(expense);
        expenseService.deleteExpense(1);
        assertEquals(0, expenseService.getAllExpenses().size());
    }

    @Test
    void testGetTotalAmount() {
        expenseService.addExpense(new Expense(0, "Food", 
                100.0, "Food", LocalDate.now(), "Lunch"));
        expenseService.addExpense(new Expense(0, "Travel", 
                200.0, "Travel", LocalDate.now(), "Bus"));
        assertEquals(300.0, expenseService.getTotalAmount());
    }

    @Test
    void testFilterByCategory() {
        expenseService.addExpense(new Expense(0, "Food", 
                100.0, "Food", LocalDate.now(), "Lunch"));
        expenseService.addExpense(new Expense(0, "Bus", 
                200.0, "Travel", LocalDate.now(), "Bus"));
        assertEquals(1, expenseService
                .getExpensesByCategory("Food").size());
    }

    @Test
    void testEmptyExpenses() {
        assertEquals(0, expenseService.getAllExpenses().size());
        assertEquals(0.0, expenseService.getTotalAmount());
    }
}