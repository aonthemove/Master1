package com.company.gameinventory.controllers;


import com.company.gameinventory.dto.TShirt;
import com.company.gameinventory.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/tshirts") // applies to all routes in this controller
public class TShirtController {

    @Autowired
    private TShirtService shirtService;

    @PostMapping // another way to set up a POST method
    @ResponseStatus(value=HttpStatus.CREATED)
    public TShirt addTShirt(@RequestBody @Valid TShirt tshirt) {
        return shirtService.addTShirt(tshirt);
    }

    @GetMapping // another way to set up a GET method
    public List<TShirt> getAllTShirts() {
        return shirtService.getAllTShirts();
    }

    @GetMapping(value="/{id}") // maps to a GET request at /tshirts/{id}
    public TShirt getTShirtById(@PathVariable int id) {
        return shirtService.getTShirtById(id);
    }

    @GetMapping(value="/size/{size}")
    public List<TShirt> getTShirtsBySize(@PathVariable String size) {
        return shirtService.getTShirtsBySize(size);
    }

    @GetMapping(value="/color/{color}")
    public List<TShirt> getTShirtsByColor(@PathVariable String color) {
        return shirtService.getTShirtsByColor(color);
    }

    @PutMapping(value="/{id}") // maps to a PUT request at /tshirts/{id}
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody @Valid TShirt tshirt, @PathVariable int id) {
        shirtService.updateTShirt(tshirt, id);
    }

    @DeleteMapping(value="/{id}") // maps to a DELETE request at /tshirts/{id}
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) {
        shirtService.deleteTShirt(id);
    }
}
