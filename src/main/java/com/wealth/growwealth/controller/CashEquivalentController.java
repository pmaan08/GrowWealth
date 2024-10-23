package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.CashEquivalent;
import com.wealth.growwealth.service.CashEquivalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cashEquivalents")
public class CashEquivalentController {


    @Autowired
    private CashEquivalentService cashEquivalentService;

    @PostMapping
    public ResponseEntity<CashEquivalent> createCashEquivalent(@RequestBody CashEquivalent cashEquivalent) {
        CashEquivalent savedCashEquivalent = cashEquivalentService.saveCashEquivalent(cashEquivalent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCashEquivalent);
    }

    @GetMapping
    public ResponseEntity<List<CashEquivalent>> getAllCashEquivalents() {
        List<CashEquivalent> cashEquivalents = cashEquivalentService.getAllCashEquivalents();
        return ResponseEntity.ok(cashEquivalents);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CashEquivalent> getCashEquivalentById(@PathVariable Long id) {
        CashEquivalent cashEquivalent = cashEquivalentService.getCashEquivalentById(id);
        if (cashEquivalent != null) {
            return ResponseEntity.ok(cashEquivalent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Update an existing CashEquivalent
    @PutMapping("/update/{id}")
    public ResponseEntity<CashEquivalent> updateCashEquivalent(@PathVariable Long id, @RequestBody CashEquivalent updatedCashEquivalent) {
        CashEquivalent existingCashEquivalent = cashEquivalentService.getCashEquivalentById(id);
        if (existingCashEquivalent != null) {
            existingCashEquivalent.setBankName(updatedCashEquivalent.getBankName());
            existingCashEquivalent.setAccounts(updatedCashEquivalent.getAccounts());

            CashEquivalent savedCashEquivalent = cashEquivalentService.saveCashEquivalent(existingCashEquivalent);
            return ResponseEntity.ok(savedCashEquivalent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCashEquivalent(@PathVariable Long id) {
        try {
            cashEquivalentService.deleteCashEquivalent(id);
            return ResponseEntity.ok("CashEquivalent deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
