package com.wealth.growwealth.service;

import com.wealth.growwealth.entity.Account;
import com.wealth.growwealth.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Save or update an Account
    public Account saveAccount(Account account) {
        // Ensure account has a valid account number and amount
        if (account.getAccountNumber() == null || account.getAmount() == null) {
            throw new IllegalArgumentException("Account details must be complete with account number and amount.");
        }
        return accountRepository.save(account);
    }

    // Get all Accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get an Account by ID
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    // Delete an Account by ID
    public void deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Account with ID " + id + " does not exist.");
        }
    }

}
