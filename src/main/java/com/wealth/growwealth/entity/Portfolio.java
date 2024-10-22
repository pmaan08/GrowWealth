package com.wealth.growwealth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String portfolioName;

    // Multiple portfolio -> 1 client
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    // 1 Portfolio -> many tranactions
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Stock> stocks;

    //@OneToMany(cascade = CascadeType.ALL) List<Bond> bonds
    //@OneToMany(cascade = CascadeType.ALL) List<RealEstate> realEstates
    //@OneToMany(cascade = CascadeType.ALL) List<AlternativeInvestment> alternativeInvestments
    //@OneToMany(cascade = CascadeType.ALL) List<BusinessHolding> businessHoldings
    //@OneToMany(cascade = CascadeType.ALL) List<CashEquivalent> cashEquivalents


    //getter
    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    //setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
