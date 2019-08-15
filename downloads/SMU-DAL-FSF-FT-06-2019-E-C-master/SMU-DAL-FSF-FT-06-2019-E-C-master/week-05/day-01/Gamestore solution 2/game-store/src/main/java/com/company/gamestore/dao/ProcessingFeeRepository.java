package com.company.gamestore.dao;

import com.company.gamestore.dto.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, String> {
    ProcessingFee findByProductType(String productType);
}
