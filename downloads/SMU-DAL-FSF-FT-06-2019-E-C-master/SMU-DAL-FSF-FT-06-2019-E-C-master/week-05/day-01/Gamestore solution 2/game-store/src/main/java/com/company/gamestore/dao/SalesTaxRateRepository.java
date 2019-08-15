package com.company.gamestore.dao;

import com.company.gamestore.dto.SalesTaxRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesTaxRateRepository extends JpaRepository<SalesTaxRate, String> {
    SalesTaxRate findByState(String state);
}
