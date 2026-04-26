package com.expense.expense_tracker;

import java.time.LocalDate;

public class Expense {
    
    private int id;
    private String title;
    private double amount;
    private String category;
    private LocalDate date;
    private String description;

    public Expense() {}

    public Expense(int id, String title, double amount, 
                   String category, LocalDate date, String description) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}