package com.company.televisionservicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ServiceLayer service;

    @RequestMapping(value="/televisions", method= RequestMethod.POST)
    public Television addTelevision(@RequestBody @Valid Television tv) {
        service.addTelevision(tv);
        return tv;
    }

    @RequestMapping(value="/televisions", method = RequestMethod.GET)
    public List<Television> getAllTelevisions() {
        return service.getAllTelevisions();
    }

    @RequestMapping(value="/televisions/{id}", method = RequestMethod.GET)
    public Television getTelevisionById(@PathVariable int id) {
        return service.getTelevisionById(id);
    }

    @RequestMapping(value="/televisions/{id}", method = RequestMethod.PUT)
    public void updateTelevision(@RequestBody @Valid Television tv, @PathVariable int id) {
        service.updateTelevision(tv, id);
    }

    @RequestMapping(value="/televisions/{id}", method = RequestMethod.DELETE)
    public void deleteTelevision(@PathVariable int id) {
        service.deleteTelevision(id);
    }

    @RequestMapping(value="/televisions/manufacturer/{manufacturer}", method = RequestMethod.GET)
    public List<Television> getTelevisionsByManufacturer(@PathVariable String manufacturer) {
        return service.findTelevisionsByManufacturer(manufacturer);
    }

    @RequestMapping(value="/televisions/manufacturers/{manufacturer1}/{manufacturer2}", method = RequestMethod.GET)
    public List<Television> getTelevisionsByEitherManufacturer(@PathVariable String manufacturer1, @PathVariable String manufacturer2) {
        return service.findByEitherManufacturer(manufacturer1, manufacturer2);
    }

    @RequestMapping(value="/televisions/above/{size}", method = RequestMethod.GET)
    public List<Television> getTelevisionsAboveSize(@PathVariable float size) {
        return service.findTelevisionsAboveSize(size);
    }

    @RequestMapping(value="/televisions/newer/{year}", method = RequestMethod.GET)
    public List<Television> getTelevisionsNewerThan(@PathVariable int year) {
        return service.findTelevisionsNewerThan(year);
    }

    @RequestMapping(value="/televisions/manufacturer/average/{manufacturer}", method = RequestMethod.GET)
    public double getTelevisionAverageByManufacturer(@PathVariable String manufacturer) {
        return service.findAverageByManufacturer(manufacturer);
    }
}
