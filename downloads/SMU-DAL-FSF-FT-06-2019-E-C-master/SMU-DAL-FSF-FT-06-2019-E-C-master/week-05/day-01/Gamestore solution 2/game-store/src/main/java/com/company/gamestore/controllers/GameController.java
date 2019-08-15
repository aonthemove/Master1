package com.company.gamestore.controllers;

import com.company.gamestore.dto.Game;
import com.company.gamestore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService service;

    @RequestMapping(value="/game", method= RequestMethod.POST)
    public Game addGame(@RequestBody @Valid Game game) {
        service.addGame(game);
        return game;
    }

    @RequestMapping(value="/games", method=RequestMethod.GET)
    public List<Game> getAllGames() {
        return service.getAllGames();
    }

    @RequestMapping(value="/game/{id}", method=RequestMethod.GET)
    public Game getGameById(@PathVariable int id) {
        return service.getGameById(id);
    }

    @RequestMapping(value="/game/{id}", method=RequestMethod.PUT)
    public void updateGame(@RequestBody @Valid Game game, @PathVariable int id) {
        service.updateGame(game, id);
    }

    @RequestMapping(value="/game/{id}", method=RequestMethod.DELETE)
    public void deleteGame(@PathVariable int id) {
        service.deleteGame(id);
    }

    @RequestMapping(value="/gamesByStudio/{studio}", method=RequestMethod.GET)
    public List<Game> findGamesByStudio(@PathVariable String studio) {
        return service.findGamesByStudio(studio);
    }

    @RequestMapping(value="/gamesByEsrbRating/{esrbRating}", method=RequestMethod.GET)
    public List<Game> findGamesByEsrbRating(@PathVariable String esrbRating) {
        return service.findGamesByEsrbRating(esrbRating);
    }

    @RequestMapping(value="/gamesByTitle/{title}", method=RequestMethod.GET)
    public List<Game> findGamesByTitle(@PathVariable String title) {
        return service.findGamesByTitle(title);
    }
}
