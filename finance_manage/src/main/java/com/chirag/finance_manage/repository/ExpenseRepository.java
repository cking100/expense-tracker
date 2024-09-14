package com.chirag.finance_manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chirag.finance_manage.model.Expense;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Long userId);
}
