package com.example.HabibAlizadaU1Capstone.dao;

import com.example.HabibAlizadaU1Capstone.model.Game;

import java.util.List;

public interface GameDao {
    Game addGame(Game game);
    Game getGame(int id);
    List<Game> getAllGame();
    void updateGame(Game game);
    void deleteGame(int id);
    List<Game> getGameByStudio(String studio);
    List<Game> getGameByEsrbRating(String EsrbRating);
    List<Game> getGameByTitle(String title);
}
