package com.wealth.growwealth.repository;

import com.wealth.growwealth.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
