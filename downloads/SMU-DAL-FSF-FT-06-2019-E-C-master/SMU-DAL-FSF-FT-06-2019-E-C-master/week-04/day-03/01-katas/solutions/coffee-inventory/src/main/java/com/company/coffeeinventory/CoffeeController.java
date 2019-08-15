package com.company.coffeeinventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepo;

    @RequestMapping(value="/coffee", method= RequestMethod.POST)
    public Coffee addCoffee(@RequestBody @Valid Coffee coffee) {
        coffeeRepo.save(coffee);
        return coffee;
    }

    @RequestMapping(value="/coffees", method = RequestMethod.GET)
    public List<Coffee> getAllCoffees() {
        return coffeeRepo.findAll();
    }

    @RequestMapping(value="/coffee/{id}", method = RequestMethod.GET)
    public Coffee getCoffeeById(@PathVariable int id) {
        return coffeeRepo.getOne(id);
    }

    @RequestMapping(value="/coffee/{id}", method = RequestMethod.PUT)
    public void updateCoffee(@RequestBody @Valid Coffee coffee, @PathVariable int id) {
        coffeeRepo.save(coffee);
    }

    @RequestMapping(value="/coffee/{id}", method = RequestMethod.DELETE)
    public void deleteCoffee(@PathVariable int id) {
        coffeeRepo.deleteById(id);
    }

    @RequestMapping(value="/coffeeByRoasterId/{roasterId}", method = RequestMethod.GET)
    public List<Coffee> getCoffeeByRoasterId(@PathVariable int roasterId) {
        return coffeeRepo.findByRoasterId(roasterId);
    }

    @RequestMapping(value="/coffeeByType/{type}", method = RequestMethod.GET)
    public List<Coffee> getCoffeeByType(@PathVariable String type) {
        return coffeeRepo.findByType(type);
    }

    @RequestMapping(value="/coffeeByRoasterIdAndType/{roasterId}/{type}", method = RequestMethod.GET)
    public List<Coffee> getCoffeeByRoasterIdAndType(@PathVariable int roasterId, @PathVariable String type) {
        return coffeeRepo.findByRoasterIdAndType(roasterId, type);
    }
}
