package com.company.coffeeinventory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    List<Coffee> findByRoasterId(Integer roasterId);
    List<Coffee> findByType(String type);
    List<Coffee> findByRoasterIdAndType(Integer roasterId, String type);
}
