package com.chirag.finance_manage.service;

import com.chirag.finance_manage.model.Investment;

import java.util.List;

public interface InvestmentService {

    Investment create(Investment investment);

    Investment update(Long id, Investment investment);

    List<Investment> getInvestmentsByUserId(Long userId);  // Ensure this method signature is correct

    // Other methods, if any
}
