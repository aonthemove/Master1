package com.company.controller;

import com.company.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

    private List<City> cityList = new ArrayList<>();

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public City addCity(@RequestBody @Valid City city) {
        String firstLetter = city.getName().substring(0,1);

        if ( firstLetter.equals(firstLetter.toLowerCase()) ) {
            throw new IllegalArgumentException("Cities must begin with an uppercase letter");
        }

        firstLetter = city.getState().substring(0,1);

        if ( firstLetter.equals(firstLetter.toLowerCase()) ) {
            throw new IllegalArgumentException("States must begin with an uppercase letter");
        }

        cityList.add(city);

        return city;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCity(@PathVariable String name) {

        int pos = 0;
        boolean found = false;

        for(City city : cityList) {
            if (city.getName().equalsIgnoreCase(name)) {
                found = true;
                break;
            }

            pos++;
        }

        if ( found ) {
            cityList.remove(pos);
        }
        else throw new IllegalArgumentException("City not found.");
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCities() {

        return cityList;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public City getCity(@PathVariable String name) {

        for(City city : cityList) {
            if (city.getName().equalsIgnoreCase(name))
                return city;
        }

        throw new IllegalArgumentException("City not found.");
    }

    @RequestMapping(value = "/city/population/{population}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCityAbovePopulation(@PathVariable int population) {
        List<City> citiesGreaterThan = new ArrayList<>();

        for(City city : cityList) {
            if (city.getPopulation() > population)
                citiesGreaterThan.add(city);
        }

        return citiesGreaterThan;
    }

    @RequestMapping(value = "/city/state/{state}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCityByState(@PathVariable String state) {
        List<City> stateCities = new ArrayList<>();

        for(City city : cityList) {
            if (city.getState().equalsIgnoreCase(state))
                stateCities.add(city);
        }

        return stateCities;
    }

}
