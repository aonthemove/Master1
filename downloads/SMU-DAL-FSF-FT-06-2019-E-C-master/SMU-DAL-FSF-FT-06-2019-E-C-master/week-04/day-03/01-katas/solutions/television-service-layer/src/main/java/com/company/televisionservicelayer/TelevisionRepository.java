package com.company.televisionservicelayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Integer> {
    List<Television> findByManufacturer(String manufacturer);
}
