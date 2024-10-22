package com.wealth.growwealth.config;

import com.wealth.growwealth.entity.Client;
import com.wealth.growwealth.entity.Portfolio;
import com.wealth.growwealth.service.ClientService;
import com.wealth.growwealth.service.PortfolioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

    @Bean
    public CommandLineRunner loadData(ClientService clientService, PortfolioService portfolioService) {
        return args -> {
            // Creating sample client
            Client client = new Client();
            client.setName("John Doe");
            Client savedClient = clientService.saveClient(client);

            // Creating a sample portfolio for the client
            Portfolio portfolio = new Portfolio();
            portfolio.setPortfolioName("John's Portfolio");
            portfolio.setClient(savedClient);
            portfolioService.savePortfolio(portfolio);
        };
    }
}

