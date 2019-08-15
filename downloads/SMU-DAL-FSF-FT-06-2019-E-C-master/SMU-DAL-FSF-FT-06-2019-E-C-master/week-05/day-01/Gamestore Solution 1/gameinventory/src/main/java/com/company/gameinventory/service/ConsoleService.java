package com.company.gameinventory.service;

import com.company.gameinventory.dao.ConsoleRepository;
import com.company.gameinventory.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepo;

    public Console addConsole(Console console) {
        return consoleRepo.save(console);
    }

    public List<Console> getAllConsoles() {
        return consoleRepo.findAll();
    }

    public Console getConsoleById(Integer id) {
        return consoleRepo.getOne(id);
    }

    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return consoleRepo.findByManufacturer(manufacturer);
    }

    public void updateConsole(Console console, Integer id) {
        if (console.getConsoleId() != id) {
            throw new IllegalArgumentException("Console ID must match the ID provided");
        }

        consoleRepo.save(console);
    }

    public void deleteConsole(Integer id) {
        consoleRepo.deleteById(id);
    }
}
