package com.company.gamestore.service;

import com.company.gamestore.dao.ConsoleRepository;
import com.company.gamestore.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleService {
    @Autowired
    private ConsoleRepository consoleRepo;

    public Console addConsole(Console console) {
        consoleRepo.save(console);
        return console;
    }

    public List<Console> getAllConsoles() {
        return consoleRepo.findAll();
    }

    public Console getConsoleById(int id) {
        return consoleRepo.getOne(id);
    }

    public void updateConsole(Console console, int id) {
        consoleRepo.save(console);
    }

    public void deleteConsole(int id) {
        consoleRepo.deleteById(id);
    }

    public List<Console> findConsolesByManufacturer(String manufacturer) {
        return consoleRepo.findByManufacturer(manufacturer);
    }
}
