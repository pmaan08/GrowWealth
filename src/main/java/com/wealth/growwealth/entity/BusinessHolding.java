package com.wealth.growwealth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusinessHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private Double ownershipPercentage;
    private Double numberOfShares;
    private Double currentMarketPrice;

    public Double getOwnershipPercentage() {
        return ownershipPercentage;
    }

    public void setOwnershipPercentage(Double ownershipPercentage) {
        this.ownershipPercentage = ownershipPercentage;
    }

    public Double getNumberOfShares() {
        return numberOfShares;
    }
    public void setNumberOfShares(Double numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getCurrentMarketPrice() {
        return currentMarketPrice;
    }
    public void setCurrentMarketPrice(Double currentMarketPrice) {
        this.currentMarketPrice = currentMarketPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Derived attribute for total amount (percentage * current price * number of shares)
    public Double getTotalAmount() {
        return ownershipPercentage * currentMarketPrice * numberOfShares;
    }

}
