package com.expense.expense_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("expenses", 
            expenseService.getAllExpenses());
        model.addAttribute("total", 
            expenseService.getTotalAmount());
        model.addAttribute("newExpense", new Expense());
        return "index";
    }

    @PostMapping("/add")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseService.addExpense(expense);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return "redirect:/";
    }

    @GetMapping("/filter")
    public String filterByCategory(
            @RequestParam String category, Model model) {
        model.addAttribute("expenses", 
            expenseService.getExpensesByCategory(category));
        model.addAttribute("total", 
            expenseService.getTotalAmount());
        model.addAttribute("newExpense", new Expense());
        return "index";
    }
}