package com.wealth.growwealth.service;

import com.wealth.growwealth.entity.BusinessHolding;
import com.wealth.growwealth.repository.BusinessHoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessHoldingService {

    @Autowired
    private BusinessHoldingRepository businessHoldingRepository;

    public BusinessHolding saveBusinessHoldings(BusinessHolding businessHolding) {
        return businessHoldingRepository.save(businessHolding);
    }

    public List<BusinessHolding> getAllBusinessHoldings() {
        return businessHoldingRepository.findAll();
    }

    public BusinessHolding getBusinessHoldingById(Long id) {
        return businessHoldingRepository.findById(id).orElse(null);
    }

    public void deleteBusinessHolding(Long id) {
        businessHoldingRepository.deleteById(id);
    }
}
