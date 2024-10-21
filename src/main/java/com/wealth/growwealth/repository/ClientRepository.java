package com.wealth.growwealth.repository;

import com.wealth.growwealth.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
