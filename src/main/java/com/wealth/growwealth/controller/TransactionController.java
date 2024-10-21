package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.Transaction;
import com.wealth.growwealth.service.TranactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TranactionService tranactionService;

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        Transaction  savedTransaction = tranactionService.saveTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
            return tranactionService.getAllTransactions();
    }
}
