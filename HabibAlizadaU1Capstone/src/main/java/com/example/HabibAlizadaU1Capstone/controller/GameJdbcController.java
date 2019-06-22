package com.example.HabibAlizadaU1Capstone.controller;

import com.example.HabibAlizadaU1Capstone.dao.GameDao;
import com.example.HabibAlizadaU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameJdbcController {

    @Autowired
    GameDao gameDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game){
        return gameDao.addGame(game);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGame(@PathVariable("id") int gameId){
        return gameDao.getGame(gameId);
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable("studio") String studio){
        return gameDao.getGameByStudio(studio);
    }

    @GetMapping("/esrbrating/{esrbrating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByEsrbRating(@PathVariable("esrbrating") String esrbrating){
        return gameDao.getGameByEsrbRating(esrbrating);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGameByTitle(@PathVariable("title") String title){
        return gameDao.getGameByTitle(title);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames(){
        return gameDao.getAllGame();
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId) {
        gameDao.deleteGame(gameId);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int gameId, @RequestBody @Valid Game game) {
        if (game.getGameId() == 0)
            game.setGameId(gameId);
        if (gameId != game.getGameId()) {
            throw new IllegalArgumentException("Game ID on path must match the ID in the Game object");
        }
        gameDao.updateGame(game);
    }
}
