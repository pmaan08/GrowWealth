package com.wealth.growwealth.service;

import com.wealth.growwealth.entity.Stock;
import com.wealth.growwealth.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
