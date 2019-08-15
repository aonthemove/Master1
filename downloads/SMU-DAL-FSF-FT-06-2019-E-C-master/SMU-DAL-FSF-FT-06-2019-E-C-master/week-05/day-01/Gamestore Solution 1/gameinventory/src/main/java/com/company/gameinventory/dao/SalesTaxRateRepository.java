package com.company.gameinventory.dao;

import com.company.gameinventory.dto.SalesTaxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTaxRateRepository extends JpaRepository<SalesTaxRate, String> {

}
