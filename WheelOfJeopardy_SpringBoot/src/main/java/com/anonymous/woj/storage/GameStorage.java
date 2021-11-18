package com.anonymous.woj.storage;

import com.anonymous.woj.entity.Game;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: store the game in java memory, can be transfer to a database
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/18
 */
public class GameStorage {
    // key: gameId
    // value: game object
    private static Map<String, Game> games;
    private static GameStorage instance;

    private GameStorage(){
        games = new HashMap<>();
    }

    public static synchronized GameStorage getInstance(){
        if(instance ==null){
            instance = new GameStorage();
        }
        return instance;
    }

    public Map<String, Game> getGames(){
        return games;
    }
    public void setGames(Game game){
        games.put(game.getGameId(),game);
    }

}
