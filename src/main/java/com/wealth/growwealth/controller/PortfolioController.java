package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.Portfolio;
import com.wealth.growwealth.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;



    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
            return portfolioService.savePortfolio(portfolio);
    }

    @GetMapping
    public List<Portfolio> getPortfolios() {
        return portfolioService.getAllPortfolios();
    }
}
