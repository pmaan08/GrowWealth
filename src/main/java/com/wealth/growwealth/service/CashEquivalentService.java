package com.wealth.growwealth.service;

import com.wealth.growwealth.entity.Account;
import com.wealth.growwealth.entity.CashEquivalent;
import com.wealth.growwealth.repository.CashEquivalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashEquivalentService {

    @Autowired
    private CashEquivalentRepository cashEquivalentRepository;

    public CashEquivalent saveCashEquivalent(CashEquivalent cashEquivalent) {
        List<Account> accounts = cashEquivalent.getAccounts();
        if (accounts != null) {
            for (Account account : accounts) {
                // Ensuring that any Account has valid data before saving
                if (account.getAccountNumber() == null || account.getAmount() == null) {
                    throw new IllegalArgumentException("Account details must be complete with account number and amount.");
                }
            }
        }
        return cashEquivalentRepository.save(cashEquivalent);
    }

    public List<CashEquivalent> getAllCashEquivalents() {
        return cashEquivalentRepository.findAll();
    }

    // Delete a CashEquivalent by ID
    public void deleteCashEquivalent(Long id) {
        if (cashEquivalentRepository.existsById(id)) {
            cashEquivalentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("CashEquivalent with ID " + id + " does not exist.");
        }
    }

    public CashEquivalent getCashEquivalentById(Long id) {
        return cashEquivalentRepository.getReferenceById(id);
    }
}
