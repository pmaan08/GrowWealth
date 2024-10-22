package com.wealth.growwealth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import org.springframework.lang.NonNull;

@Entity
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "OWNED|RENT", message = "Type must be either OWNED or RENT")
    private String propertyType;
    private String address;
    private Double value;
    // 1 for rented , 0 for owned(no incoming income)
    private Integer status;

    public  String getPropertyType() {
        return propertyType;
    }


    public void setPropertyType(String propertyType) {
        if (propertyType.equalsIgnoreCase("owned") || propertyType.equalsIgnoreCase("rented")) {
            this.propertyType = propertyType;
        } else {
            throw new IllegalArgumentException("Property type must be 'owned' or 'rented'");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if (status == 0 || status == 1) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status must be 0 (Owned) or 1 (Rented)");
        }
    }
}
