package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.RealEstate;
import com.wealth.growwealth.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/realEstate")
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @PostMapping
    public ResponseEntity<RealEstate> createRealEstate(@RequestBody RealEstate realEstate) {
        RealEstate newRealEstate = realEstateService.save(realEstate);
        return ResponseEntity.ok(newRealEstate);
    }

    @GetMapping
    public ResponseEntity<List<RealEstate>> getAllRealEstate() {
        List<RealEstate> realEstateList = realEstateService.getAllRealEstate();
        return ResponseEntity.ok(realEstateList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RealEstate> updateRealEstate(@PathVariable Long id, @RequestBody RealEstate updatedRealEstate) {
        RealEstate existingRealEstate = realEstateService.getRealEstateById(id);
        if (existingRealEstate != null) {
            // Update the fields
            existingRealEstate.setPropertyType(updatedRealEstate.getPropertyType());
            existingRealEstate.setAddress(updatedRealEstate.getAddress());
            existingRealEstate.setValue(updatedRealEstate.getValue());
            existingRealEstate.setStatus(updatedRealEstate.getStatus());

            RealEstate savedRealEstate = realEstateService.save(existingRealEstate);
            return ResponseEntity.ok(savedRealEstate);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Delete a RealEstate by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRealEstate(@PathVariable Long id) {
        boolean isDeleted = realEstateService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("RealEstate deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RealEstate not found.");
    }





}
