package com.company.gamestore.controllers;

import com.company.gamestore.dto.TShirt;
import com.company.gamestore.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TShirtController {
    @Autowired
    private TShirtService service;

    @RequestMapping(value="/tshirt", method= RequestMethod.POST)
    public TShirt addTShirt(@RequestBody @Valid TShirt tshirt) {
        service.addTShirt(tshirt);
        return tshirt;
    }

    @RequestMapping(value="/tshirts", method=RequestMethod.GET)
    public List<TShirt> getAllTShirts() {
        return service.getAllTShirts();
    }

    @RequestMapping(value="/tshirt/{id}", method=RequestMethod.GET)
    public TShirt getTShirtById(@PathVariable int id) {
        return service.getTShirtById(id);
    }

    @RequestMapping(value="/tshirt/{id}", method=RequestMethod.PUT)
    public void updateTShirt(@RequestBody @Valid TShirt tshirt, @PathVariable int id) {
        service.updateTShirt(tshirt, id);
    }

    @RequestMapping(value="/tshirt/{id}", method=RequestMethod.DELETE)
    public void deleteTShirt(@PathVariable int id) {
        service.deleteTShirt(id);
    }

    @RequestMapping(value="/tshirtsByColor/{color}", method=RequestMethod.GET)
    public List<TShirt> findTShirtsByColor(@PathVariable String color) {
        return service.findTShirtsByColor(color);
    }

    @RequestMapping(value="/tshirtsBySize/{size}", method=RequestMethod.GET)
    public List<TShirt> findTShirtsBySize(@PathVariable String size) {
        return service.findTShirtsBySize(size);
    }
}
