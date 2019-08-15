package com.company.gameinventory.service;

import com.company.gameinventory.dao.GameRepository;
import com.company.gameinventory.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    public Game addGame(Game game) {
        return gameRepo.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }

    public Game getGameById(Integer id) {
        return gameRepo.getOne(id);
    }

    public List<Game> getGamesByRating(String rating) {
        return gameRepo.findByEsrbRating(rating);
    }

    public List<Game> getGamesByStudio(String studio) {
        return gameRepo.findByStudio(studio);
    }

    public List<Game> getGamesByTitle(String title) {
        return gameRepo.findByTitle(title);
    }

    public void updateGame(Game game, Integer id) {
        if (game.getGameId() != id) {
            throw new IllegalArgumentException("Game ID must match the ID provided");
        }

        gameRepo.save(game);
    }

    public void deleteGame(Integer id) {
        gameRepo.deleteById(id);
    }
}
