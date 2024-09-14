package com.chirag.finance_manage.service;
import java.util.List;
import com.chirag.finance_manage.model.Budget;
public interface BudgetService {
    Budget create(Budget budget);
    Budget update(Long id, Budget budget);
    void delete(Long id);


    List<Budget> getBudgetsByUserId(Long userId);
}
