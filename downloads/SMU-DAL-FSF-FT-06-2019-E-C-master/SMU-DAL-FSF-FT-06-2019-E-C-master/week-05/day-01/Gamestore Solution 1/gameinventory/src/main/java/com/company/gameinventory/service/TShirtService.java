package com.company.gameinventory.service;

import com.company.gameinventory.dao.TShirtRepository;
import com.company.gameinventory.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TShirtService {

    @Autowired
    private TShirtRepository consoleRepo;

    public TShirt addTShirt(TShirt tshirt) {
        return consoleRepo.save(tshirt);
    }

    public List<TShirt> getAllTShirts() {
        return consoleRepo.findAll();
    }

    public TShirt getTShirtById(Integer id) {
        return consoleRepo.getOne(id);
    }

    public List<TShirt> getTShirtsByColor(String color) {
        return consoleRepo.findByColor(color);
    }

    public List<TShirt> getTShirtsBySize(String size) {
        return consoleRepo.findBySize(size);
    }

    public void updateTShirt(TShirt tshirt, Integer id) {
        if (tshirt.gettShirtId() != id) {
            throw new IllegalArgumentException("TShirt ID must match the ID provided");
        }

        consoleRepo.save(tshirt);
    }

    public void deleteTShirt(Integer id) {
        consoleRepo.deleteById(id);
    }
}
