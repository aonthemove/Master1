package com.company.gamestore.dao;

import com.company.gamestore.dto.Console;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsoleRepository extends JpaRepository<Console, Integer> {
    List<Console> findByManufacturer(String manufacturer);
}
