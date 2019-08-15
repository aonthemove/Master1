package com.company.gameinventory.controllers;

import com.company.gameinventory.dto.Game;
import com.company.gameinventory.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/games") // applies to all routes in this controller
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping // another way to set up a POST method
    @ResponseStatus(value=HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game) {
        return gameService.addGame(game);
    }

    @GetMapping // another way to set up a GET method
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping(value="/{id}") // maps to a GET request at /games/{id}
    public Game getGameById(@PathVariable int id) {
        return gameService.getGameById(id);
    }

    @GetMapping(value="/rating/{rating}")
    public List<Game> getGameByRating(@PathVariable String rating) {
        return gameService.getGamesByRating(rating);
    }

    @GetMapping(value="/studio/{studio}")
    public List<Game> getGameByStudio(@PathVariable String studio) {
        return gameService.getGamesByStudio(studio);
    }

    @GetMapping(value="/title/{title}")
    public List<Game> getGameByTitle(@PathVariable String title) {
        return gameService.getGamesByTitle(title);
    }

    @PutMapping(value="/{id}") // maps to a PUT request at /games/{id}
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid Game game, @PathVariable int id) {
        gameService.updateGame(game, id);
    }

    @DeleteMapping(value="/{id}") // maps to a DELETE request at /games/{id}
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        gameService.deleteGame(id);
    }
}
