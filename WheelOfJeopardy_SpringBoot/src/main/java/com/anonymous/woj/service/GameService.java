package com.anonymous.woj.service;

import com.anonymous.woj.entity.Game;
import com.anonymous.woj.entity.GamePlay;
import com.anonymous.woj.entity.GameStatus;
import com.anonymous.woj.entity.Player;
import com.anonymous.woj.storage.GameStorage;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/14
 */
@Service

public class GameService {



    public Game createGame(Player player){
        Game game = new Game();
        game.setGameId(UUID.randomUUID().toString());
        game.setPlayer1(player);
        game.setStatus(GameStatus.NEW);
        GameStorage.getInstance().setGames(game);
        return game;
    }
    public Game connectToGame(Player playerJoining, String gameId){

        if(!GameStorage.getInstance().getGames().containsKey(gameId)){
            //game invalid
            //there is no such game to connect
            //TODO
            System.out.println("there is no such game to connect");
        }
        //else get that game
        Game game = GameStorage.getInstance().getGames().get(gameId);
        if(game.getPlayer2()!=null&&game.getPlayer3()!=null){
            //invalid game to join
            //the room is full
            //TODO
            System.out.println("the room is full");
        }else if(game.getPlayer2()!=null){
            //there is two player in the room
            game.setPlayer3(playerJoining);
            //the room is full, the game can start
            game.setStatus(GameStatus.IN_PROGRESS);
            GameStorage.getInstance().setGames(game);

        }else{
            // only one player in the room
            game.setPlayer2(playerJoining);
        }

        return game;
    }

    /**
     * Track status of a game
     * @return
     */
    public Game gamePlay(GamePlay gamePlay){

        if(!GameStorage.getInstance().getGames().containsKey(gamePlay.getGameId())){
            //game invalid
            //there is no such game to connect
            //TODO
            System.out.println("there is no such game to connect");
        }
        Game game = GameStorage.getInstance().getGames().get(gamePlay.getGameId());
        if(game.getStatus().equals(GameStatus.FINISHED)){
            //game already finished
            //TODO
            System.out.println("game already finished");
        }

        //add point for that player

        //compare with player's name, which mean they cannot have the same name in the same game
        if(gamePlay.getPlayer().getLogin().equals(game.getPlayer1().getLogin())){

            int score = game.getPlayer1().getScore();

            game.getPlayer1().setScore(score+gamePlay.getScoreEarned());
        }else if(gamePlay.getPlayer().getLogin().equals(game.getPlayer2().getLogin())){
            int score = game.getPlayer2().getScore();
            game.getPlayer2().setScore(score+gamePlay.getScoreEarned());
        }else {
            int score = game.getPlayer3().getScore();
            game.getPlayer3().setScore(score+gamePlay.getScoreEarned());
        }



        if (checkWinner(game.getPlayer1())) {
            game.setStatus(GameStatus.FINISHED);
            game.setWinner(game.getPlayer1());
        }
        if (checkWinner(game.getPlayer2())) {
            game.setStatus(GameStatus.FINISHED);
            game.setWinner(game.getPlayer2());
        }
        if (checkWinner(game.getPlayer3())) {
            game.setStatus(GameStatus.FINISHED);
            game.setWinner(game.getPlayer3());
        }


        GameStorage.getInstance().setGames(game);
        return game;

    }

    private Boolean checkWinner(Player player) {
        int winnerScore = 1000;
        return player.getScore()>=winnerScore;
    }


    public Map<String, Game> getAllGames() {
        return GameStorage.getInstance().getGames();
    }
}
