package com.wealth.growwealth.repository;

import com.wealth.growwealth.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
