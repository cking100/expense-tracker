package com.chirag.finance_manage.service;

import com.chirag.finance_manage.model.Investment;
import com.chirag.finance_manage.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentServiceImpl(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @Override
    public Investment create(Investment investment) {
        return investmentRepository.save(investment);
    }

    @Override
    public Investment update(Long id, Investment investment) {
        Investment existingInvestment = investmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        existingInvestment.setSymbol(investment.getSymbol());
        existingInvestment.setAmountInvested(investment.getAmountInvested());
        existingInvestment.setPurchaseDate(investment.getPurchaseDate());
        existingInvestment.setCurrentValue(investment.getCurrentValue());

        return investmentRepository.save(existingInvestment);
    }

    @Override
    public List<Investment> getInvestmentsByUserId(Long userId) {  // This method must match the interface
        return investmentRepository.findByUserId(userId);
    }
}
