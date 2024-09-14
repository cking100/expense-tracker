package com.chirag.finance_manage.service;

import com.chirag.finance_manage.model.Expense;
import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense createExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
    boolean deleteExpense(Long id);
}
