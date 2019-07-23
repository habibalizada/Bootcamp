package com.example.HabibAlizadaU1Capstone.dao;

import com.example.HabibAlizadaU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {

        List<Game> gameList = gameDao.getAllGame();
        for (Game game : gameList){
            gameDao.deleteGame(game.getGameId());
        }
    }

    @Test
    public void addGetDeleteGame() {

        Game game = new Game();
        game.setTitle("Spider-Man");
        game.setEsrbRating("E");
        game.setDescription("Marvel's Spider-Man is a 2018 action-adventure game developed by Insomniac Games and published by Sony Interactive Entertainment.");
        game.setPrice(24.95);
        game.setStudio("Insomniac Games");
        game.setQuantity(30);

        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());

        assertEquals(game1, game);

        gameDao.deleteGame(game.getGameId());

        game1 = gameDao.getGame(game.getGameId());

        assertNull(game1);
    }

    @Test
    public void updateGame() {

        Game game = new Game();
        game.setTitle("Spider-Man");
        game.setEsrbRating("E");
        game.setDescription("Marvel's Spider-Man is a 2018 action-adventure game developed by Insomniac Games and published by Sony Interactive Entertainment.");
        game.setPrice(24.95);
        game.setStudio("Insomniac Games");
        game.setQuantity(30);

        game = gameDao.addGame(game);

        game.setTitle("Days Gone");
        game.setEsrbRating("RP");
        game.setDescription("Days Gone is an action-adventure survival horror video game developed by SIE Bend Studio.");
        game.setPrice(30.99);
        game.setStudio("SIE Bend Studio");
        game.setQuantity(5);

        gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());

        assertEquals(game1, game);
    }

    @Test
    public void getAllGame() {

        Game game = new Game();
        game.setTitle("Spider-Man");
        game.setEsrbRating("E");
        game.setDescription("Marvel's Spider-Man is a 2018 action-adventure game developed by Insomniac Games and published by Sony Interactive Entertainment.");
        game.setPrice(24.95);
        game.setStudio("Insomniac Games");
        game.setQuantity(30);

        gameDao.addGame(game);

        game.setTitle("Days Gone");
        game.setEsrbRating("RP");
        game.setDescription("Days Gone is an action-adventure survival horror video game developed by SIE Bend Studio.");
        game.setPrice(30.99);
        game.setStudio("SIE Bend Studio");
        game.setQuantity(5);

        gameDao.addGame(game);

        List<Game> gameList = gameDao.getAllGame();
        assertEquals(gameList.size(),2);
    }

    @Test
    public void getGameByStudio() {
        Game game = new Game();
        game.setTitle("Spider-Man");
        game.setEsrbRating("E");
        game.setDescription("Marvel's Spider-Man is a 2018 action-adventure game developed by Insomniac Games and published by Sony Interactive Entertainment.");
        game.setPrice(24.95);
        game.setStudio("Insomniac Games");
        game.setQuantity(30);

        gameDao.addGame(game);

        game.setTitle("Days Gone");
        game.setEsrbRating("RP");
        game.setDescription("Days Gone is an action-adventure survival horror video game developed by SIE Bend Studio.");
        game.setPrice(30.99);
        game.setStudio("SIE Bend Studio");
        game.setQuantity(5);

        gameDao.addGame(game);

        game.setTitle("Days Gone");
        game.setEsrbRating("RP");
        game.setDescription("Days Gone is an action-adventure survival horror video game developed by SIE Bend Studio.");
        game.setPrice(30.99);
        game.setStudio("SIE Bend Studio");
        game.setQuantity(5);

        gameDao.addGame(game);

        List<Game> gameList = gameDao.getGameByStudio("SIE Bend Studio");
        assertEquals(gameList.size(),2);
    }

    @Test
    public void getGameByEsrbRating() {
        Game game = new Game();
        game.setTitle("Spider-Man");
        game.setEsrbRating("E");
        game.setDescription("Marvel's Spider-Man is a 2018 action-adventure game developed by Insomniac Games and published by Sony Interactive Entertainment.");
        game.setPrice(24.95);
        game.setStudio("Insomniac Games");
        game.setQuantity(30);

        gameDao.addGame(game);

        game.setTitle("Days Gone");
        game.setEsrbRating("RP");
        game.setDescription("Days Gone is an action-adventure survival horror video game developed by SIE Bend Studio.");
        game.setPrice(30.99);
        game.setStudio("SIE Bend Studio");
        game.setQuantity(5);

        gameDao.addGame(game);

        game.setTitle("Days Gone");
        game.setEsrbRating("RP");
        game.setDescription("Days Gone is an action-adventure survival horror video game developed by SIE Bend Studio.");
        game.setPrice(30.99);
        game.setStudio("SIE Bend Studio");
        game.setQuantity(5);

        gameDao.addGame(game);

        List<Game> gameList = gameDao.getGameByEsrbRating("RP");
        assertEquals(gameList.size(),2);
    }

    @Test
    public void getGameByTitle() {
        Game game = new Game();
        game.setTitle("Spider-Man");
        game.setEsrbRating("E");
        game.setDescription("Marvel's Spider-Man is a 2018 action-adventure game developed by Insomniac Games and published by Sony Interactive Entertainment.");
        game.setPrice(24.95);
        game.setStudio("Insomniac Games");
        game.setQuantity(30);

        gameDao.addGame(game);

        game.setTitle("Days Gone");
        game.setEsrbRating("RP");
        game.setDescription("Days Gone is an action-adventure survival horror video game developed by SIE Bend Studio.");
        game.setPrice(30.99);
        game.setStudio("SIE Bend Studio");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        game.setTitle("Days Gone");
        game.setEsrbRating("RP");
        game.setDescription("Days Gone is an action-adventure survival horror video game developed by SIE Bend Studio.");
        game.setPrice(30.99);
        game.setStudio("SIE Bend Studio");
        game.setQuantity(5);

        game = gameDao.addGame(game);

        List<Game> gameList = gameDao.getGameByTitle("Days Gone");

        assertEquals(gameList.size(),2);

    }
}




















