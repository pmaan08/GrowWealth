package com.wealth.growwealth.repository;

import com.wealth.growwealth.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}
