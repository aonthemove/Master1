package com.company.gamestore.controllers;

import com.company.gamestore.dto.Console;
import com.company.gamestore.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {
    @Autowired
    private ConsoleService service;

    @RequestMapping(value="/console", method= RequestMethod.POST)
    public Console addConsole(@RequestBody @Valid Console console) {
        return service.addConsole(console);
    }

    @RequestMapping(value="/consoles", method=RequestMethod.GET)
    public List<Console> getAllConsoles() {
        return service.getAllConsoles();
    }

    @RequestMapping(value="/console/{id}", method=RequestMethod.GET)
    public Console getConsoleById(@PathVariable int id) {
        return service.getConsoleById(id);
    }

    @RequestMapping(value="/console/{id}", method=RequestMethod.PUT)
    public void updateConsole(@RequestBody @Valid Console console, @PathVariable int id) {
        service.updateConsole(console, id);
    }

    @RequestMapping(value="/console/{id}", method=RequestMethod.DELETE)
    public void deleteConsole(@PathVariable int id) {
        service.deleteConsole(id);
    }

    @RequestMapping(value="/consolesByManufacturer/{manufacturer}", method=RequestMethod.GET)
    public List<Console> findConsolesByManufacturer(@PathVariable String manufacturer) {
        return service.findConsolesByManufacturer(manufacturer);
    }
}
