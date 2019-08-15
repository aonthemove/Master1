package com.company.gameinventory.controllers;

import com.company.gameinventory.dto.Console;
import com.company.gameinventory.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/consoles") // applies to all routes in this controller
public class ConsoleController {

    @Autowired
    private ConsoleService consoleService;

    @PostMapping // another way to set up a POST method
    @ResponseStatus(value=HttpStatus.CREATED)
    public Console addConsole(@RequestBody @Valid Console console) {
        return consoleService.addConsole(console);
    }

    @GetMapping // another way to set up a GET method
    public List<Console> getAllConsoles() {
        return consoleService.getAllConsoles();
    }

    @GetMapping(value="/{id}") // maps to a GET request at /consoles/{id}
    public Console getConsoleById(@PathVariable int id) {
        return consoleService.getConsoleById(id);
    }

    @GetMapping(value="/manufacturer/{manufacturer}")
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {
        return consoleService.getConsolesByManufacturer(manufacturer);
    }

    @PutMapping(value="/{id}") // maps to a PUT request at /consoles/{id}
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid Console console, @PathVariable int id) {
        consoleService.updateConsole(console, id);
    }

    @DeleteMapping(value="/{id}") // maps to a DELETE request at /consoles/{id}
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        consoleService.deleteConsole(id);
    }
}
