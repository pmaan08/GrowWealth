package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.Stock;
import com.wealth.growwealth.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/{id}")
    public Stock getStockById(@RequestParam int id) {
        return stockService.getStockById((long) id);
    }

    @GetMapping("/all")
    public List<Stock> getAllPortfolioStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping("/add")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock savedStock = stockService.saveStock(stock);
        return ResponseEntity.ok(savedStock);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> removeStock(@RequestBody Long id) {
        try {
            stockService.deleteStock(id);
            return ResponseEntity.ok("Stock removed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete stock: " + e.getMessage());
        }
    }

}
