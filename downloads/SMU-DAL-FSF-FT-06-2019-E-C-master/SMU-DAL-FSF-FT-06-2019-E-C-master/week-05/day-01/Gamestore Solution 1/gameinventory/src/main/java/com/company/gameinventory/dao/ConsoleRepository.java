package com.company.gameinventory.dao;

import com.company.gameinventory.dto.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {

    List<Console> findByManufacturer(String manufacturer);
}
