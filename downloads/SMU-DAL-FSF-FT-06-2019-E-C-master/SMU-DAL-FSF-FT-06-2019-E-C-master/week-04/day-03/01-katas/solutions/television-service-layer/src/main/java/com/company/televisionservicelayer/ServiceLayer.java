package com.company.televisionservicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {
    @Autowired
    private TelevisionRepository tvRepo;

    public Television addTelevision(Television tv) {
        tvRepo.save(tv);
        return tv;
    }

    public List<Television> getAllTelevisions() {
        return tvRepo.findAll();
    }

    public Television getTelevisionById(int id) {
        return tvRepo.getOne(id);
    }

    public void updateTelevision(Television tv, int id) {
        if(tv.getId() != id) {
            throw new IllegalArgumentException("Id must match the id provided");
        }
        tvRepo.save(tv);
    }

    public void deleteTelevision(int id) {
        tvRepo.deleteById(id);
    }

    public List<Television> findTelevisionsByManufacturer(String manufacturer) {
        return tvRepo.findByManufacturer(manufacturer);
    }

    public List<Television> findTelevisionsAboveSize(float size) {
        List<Television> matches = new ArrayList<>();

        for (Television tv : tvRepo.findAll()) {
            if (tv.getScreenSize() >= size) {
                matches.add(tv);
            }
        }

        return matches;
    }

    public List<Television> findTelevisionsNewerThan(int year) {
        List<Television> matches = new ArrayList<>();

        for (Television tv : tvRepo.findAll()) {
            if (tv.getYear() >= year) {
                matches.add(tv);
            }
        }

        return matches;
    }

    public List<Television> findByEitherManufacturer(String manufacturer1, String manufacturer2) {
        List<Television> matches = new ArrayList<>();

        for (Television tv : tvRepo.findAll()) {
            String currManufacturer = tv.getManufacturer();
            if (currManufacturer.equals(manufacturer1) || currManufacturer.equals(manufacturer2)) {
                matches.add(tv);
            }
        }

        return matches;
    }

    public double findAverageByManufacturer(String manufacturer) {
        double total = 0.0;
        int count = 0;

        for (Television tv : tvRepo.findAll()) {
            if (tv.getManufacturer().equals(manufacturer)) {
                total += tv.getScreenSize();
                count++;
            }
        }

        return total / count;
    }
}
