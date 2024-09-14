package com.chirag.finance_manage.service;

import com.chirag.finance_manage.model.Budget;
import com.chirag.finance_manage.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Override
    public Budget create(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public Budget update(Long id, Budget budget) {
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));

        existingBudget.setCategory(budget.getCategory());
        existingBudget.setAmount(budget.getAmount());

        return budgetRepository.save(existingBudget);
    }

    @Override
    public void delete(Long id) {
        budgetRepository.deleteById(id);
    }

    @Override
    public List<Budget> getBudgetsByUserId(Long userId) {
        // Corrected to fetch the list of budgets by the user ID
        return (List<Budget>) budgetRepository.findAllByUserId(userId);
    }
}
