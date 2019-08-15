package com.company.carlot.controller;

import com.company.carlot.dao.CarLotRepository;
import com.company.carlot.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarLotController {

    @Autowired
    private CarLotRepository carlotRepo;


    @RequestMapping(value="/car", method = RequestMethod.POST)
    public Car createCar(@RequestBody Car car) {
        carlotRepo.save(car);
        return car;
    }

    @RequestMapping(value="/car/{id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable(name="id") int id) {
        return carlotRepo.findOne(id);
    }

    @RequestMapping(value="/car/{id}", method = RequestMethod.PUT)
    public void updateCar(@RequestBody Car aCar, @PathVariable(name = "id") int id) {
        carlotRepo.save(aCar);
    }

    @RequestMapping(value="/car/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable(name = "id") int id) {
        carlotRepo.delete(id);
    }

    @RequestMapping(value="/cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return carlotRepo.findAll();
    }
}
