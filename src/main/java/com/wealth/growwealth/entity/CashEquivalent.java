package com.wealth.growwealth.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CashEquivalent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String bankName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts; // accounts holding cash

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
