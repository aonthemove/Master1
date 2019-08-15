package com.company.gameinventory.dao;

import com.company.gameinventory.dto.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findByStudio(String studio);
    List<Game> findByEsrbRating(String esrbRating);
    List<Game> findByTitle(String title);
}
