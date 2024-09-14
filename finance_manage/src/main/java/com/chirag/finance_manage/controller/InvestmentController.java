package com.chirag.finance_manage.controller;

import com.chirag.finance_manage.model.Investment;
import com.chirag.finance_manage.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public Investment createInvestment(@RequestBody Investment investment) {
        return investmentService.create(investment);
    }

    @PutMapping("/{id}")
    public Investment updateInvestment(@PathVariable Long id, @RequestBody Investment investment) {
        return investmentService.update(id, investment);
    }

    @GetMapping("/user/{userId}")
    public List<Investment> getInvestmentsByUserId(@PathVariable Long userId) {
        return investmentService.getInvestmentsByUserId(userId);
    }
}
