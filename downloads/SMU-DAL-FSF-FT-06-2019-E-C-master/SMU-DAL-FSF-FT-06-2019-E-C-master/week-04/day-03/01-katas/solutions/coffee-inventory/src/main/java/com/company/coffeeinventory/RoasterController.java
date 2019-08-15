package com.company.coffeeinventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoasterController {
    @Autowired
    private RoasterRepository roasterRepo;

    @RequestMapping(value="/roaster", method= RequestMethod.POST)
    public Roaster addRoaster(@RequestBody @Valid Roaster roaster) {
        roasterRepo.save(roaster);
        return roaster;
    }

    @RequestMapping(value="/roasters", method = RequestMethod.GET)
    public List<Roaster> getAllRoasters() {
        return roasterRepo.findAll();
    }

    @RequestMapping(value="/roaster/{id}", method = RequestMethod.GET)
    public Roaster getRoasterById(@PathVariable int id) {
        return roasterRepo.getOne(id);
    }

    @RequestMapping(value="/roaster/{id}", method = RequestMethod.PUT)
    public void updateRoaster(@RequestBody @Valid Roaster roaster, @PathVariable int id) {
        roasterRepo.save(roaster);
    }

    @RequestMapping(value="/roaster/{id}", method = RequestMethod.DELETE)
    public void deleteRoaster(@PathVariable int id) {
        roasterRepo.deleteById(id);
    }
}
