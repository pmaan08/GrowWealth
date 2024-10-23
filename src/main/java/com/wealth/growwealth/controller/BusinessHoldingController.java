package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.BusinessHolding;
import com.wealth.growwealth.service.BusinessHoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/businessHoldings")
public class BusinessHoldingController {

    @Autowired
    private BusinessHoldingService businessHoldingService;

    @PostMapping
    public ResponseEntity<BusinessHolding> create(@RequestBody BusinessHolding businessHolding) {
        BusinessHolding savedHoldings = businessHoldingService.saveBusinessHoldings(businessHolding);
        return ResponseEntity.ok(savedHoldings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessHolding> getBusinessHolding(@PathVariable Long id) {
        BusinessHolding businessHolding = businessHoldingService.getBusinessHoldingById(id);
        if (businessHolding != null) {
            return ResponseEntity.ok(businessHolding);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping
    public ResponseEntity<List<BusinessHolding>> getAllClientBusinessHoldings() {
        List<BusinessHolding> businessHoldings = businessHoldingService.getAllBusinessHoldings();
        return ResponseEntity.ok(businessHoldings);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBusinessHolding(@PathVariable Long id) {
        businessHoldingService.deleteBusinessHolding(id);
        return ResponseEntity.ok("Business Holding deleted successfully.");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<BusinessHolding> updateBusinessHolding(@PathVariable Long id, @RequestBody BusinessHolding updatedBusinessHolding) {
        BusinessHolding existingBusinessHolding = businessHoldingService.getBusinessHoldingById(id);
        if (existingBusinessHolding != null) {
            // Update the fields
            existingBusinessHolding.setCompanyName(updatedBusinessHolding.getCompanyName());
            existingBusinessHolding.setOwnershipPercentage(updatedBusinessHolding.getOwnershipPercentage());
            existingBusinessHolding.setNumberOfShares(updatedBusinessHolding.getNumberOfShares());
            existingBusinessHolding.setCurrentMarketPrice(updatedBusinessHolding.getCurrentMarketPrice());

            BusinessHolding savedBusinessHolding = businessHoldingService.saveBusinessHoldings(existingBusinessHolding);
            return ResponseEntity.ok(savedBusinessHolding);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Get the total amount of a specific Business Holding by ID
    @GetMapping("/{id}/totalAmount")
    public ResponseEntity<Double> getTotalAmount(@PathVariable Long id) {
        BusinessHolding businessHolding = businessHoldingService.getBusinessHoldingById(id);
        if (businessHolding != null) {
            return ResponseEntity.ok(businessHolding.getTotalAmount());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}

