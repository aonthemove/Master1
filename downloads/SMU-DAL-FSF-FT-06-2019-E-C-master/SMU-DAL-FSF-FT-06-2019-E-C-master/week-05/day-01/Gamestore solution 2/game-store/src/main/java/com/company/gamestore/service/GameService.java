package com.company.gamestore.service;

import com.company.gamestore.dao.GameRepository;
import com.company.gamestore.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameService {
    @Autowired
    private GameRepository gameRepo;

    public Game addGame(Game game) {
        gameRepo.save(game);
        return game;
    }

    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }

    public Game getGameById(int id) {
        return gameRepo.getOne(id);
    }

    public void updateGame(Game game, int id) {
        gameRepo.save(game);
    }

    public void deleteGame(int id) {
        gameRepo.deleteById(id);
    }

    public List<Game> findGamesByStudio(String studio) {
        return gameRepo.findByStudio(studio);
    }

    public List<Game> findGamesByEsrbRating(String esrbRating) {
        return gameRepo.findByEsrbRating(esrbRating);
    }

    public List<Game> findGamesByTitle(String title) {
        return gameRepo.findByTitle(title);
    }
}
