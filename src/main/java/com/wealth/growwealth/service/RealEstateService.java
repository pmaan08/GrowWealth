package com.wealth.growwealth.service;

import com.wealth.growwealth.entity.RealEstate;
import com.wealth.growwealth.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealEstateService {

    @Autowired
    public RealEstateRepository realEstateRepository;

    public RealEstate save(RealEstate realEstate) {
        return realEstateRepository.save(realEstate);
    }

    public RealEstate getRealEstateById(Long id) {
        return realEstateRepository.findById(id).orElse(null);
    }

    public List<RealEstate> getAllRealEstate() {
        return realEstateRepository.findAll();
    }

    public boolean deleteById(Long id) {
     if(realEstateRepository.existsById(id)) {
         realEstateRepository.deleteById(id);
         return true;
     }
     return false;
    }

}
