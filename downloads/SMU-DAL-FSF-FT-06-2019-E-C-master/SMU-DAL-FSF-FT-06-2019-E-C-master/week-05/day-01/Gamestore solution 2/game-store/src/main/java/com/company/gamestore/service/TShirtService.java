package com.company.gamestore.service;

import com.company.gamestore.dao.TShirtRepository;
import com.company.gamestore.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TShirtService {
    @Autowired
    private TShirtRepository tshirtRepo;

    public TShirt addTShirt(TShirt tshirt) {
        tshirtRepo.save(tshirt);
        return tshirt;
    }

    public List<TShirt> getAllTShirts() {
        return tshirtRepo.findAll();
    }

    public TShirt getTShirtById(int id) {
        return tshirtRepo.getOne(id);
    }

    public void updateTShirt(TShirt tshirt, int id) {
        tshirtRepo.save(tshirt);
    }

    public void deleteTShirt(int id) {
        tshirtRepo.deleteById(id);
    }

    public List<TShirt> findTShirtsByColor(String color) {
        return tshirtRepo.findByColor(color);
    }

    public List<TShirt> findTShirtsBySize(String size) {
        return tshirtRepo.findBySize(size);
    }
}
