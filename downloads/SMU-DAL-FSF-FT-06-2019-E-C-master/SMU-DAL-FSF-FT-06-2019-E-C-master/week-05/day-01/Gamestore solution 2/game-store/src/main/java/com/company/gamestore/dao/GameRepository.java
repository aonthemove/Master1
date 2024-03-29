package com.company.gamestore.dao;

import com.company.gamestore.dto.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findByStudio(String studio);
    List<Game> findByEsrbRating(String esrbRating);
    List<Game> findByTitle(String title);
}
