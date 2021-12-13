package com.anonymous.woj.service;

import com.anonymous.woj.entity.*;
import com.anonymous.woj.exception.InvalidGameException;
import com.anonymous.woj.exception.InvalidParamException;
import com.anonymous.woj.storage.GameStorage;
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
        game.setCountQuestionAnswered(0);
        GameStorage.getInstance().setGames(game);
        return game;
    }
    public Game selectCategory(int[] category,String gameId) throws InvalidParamException, InvalidGameException {
        if(!GameStorage.getInstance().getGames().containsKey(gameId)){
            //game invalid
            //there is no such game to connect
            System.out.println("there is no such game to connect");
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        Game game = GameStorage.getInstance().getGames().get(gameId);
        if(game.getStatus().equals(GameStatus.FINISHED)){
            //game already finished
            System.out.println("game already finished");
            throw new InvalidGameException("The Game correspond to the gameId is Finished");
        }

        game.setSelectedCategory(category);
        return game;

    }


    public Game connectToGame(Player playerJoining, String gameId) throws InvalidParamException, InvalidGameException{

        if(!GameStorage.getInstance().getGames().containsKey(gameId)){
            //game invalid
            //there is no such game to connect

            System.out.println("there is no such game to connect");
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        //else get that game
        Game game = GameStorage.getInstance().getGames().get(gameId);
        if(game.getPlayer2()!=null&&game.getPlayer3()!=null){
            //invalid game to join
            //the room is full
            System.out.println("the room is full");
            throw new InvalidGameException("The room correspond to the gameId is full");
        }else if(game.getPlayer2()!=null){
            //there is two player in the room

            //check if there is player with same name
            if(playerJoining.getLogin().equals(game.getPlayer1().getLogin())
                    ||playerJoining.getLogin().equals(game.getPlayer2().getLogin())){
                throw new InvalidParamException("there is a player with same login name in the room, please use another name");
            }

            game.setPlayer3(playerJoining);
            //the room is full, the game can start
            game.setStatus(GameStatus.IN_PROGRESS);
            GameStorage.getInstance().setGames(game);

        }else{
            // only one player in the room

            //check if there is player with same name
            if(playerJoining.getLogin().equals(game.getPlayer1().getLogin())){
                throw new InvalidParamException("there is a player with same login name in the room, please use another name");
            }
            game.setPlayer2(playerJoining);
        }

        return game;
    }

    /**
     * Track status of a game
     * @return
     */
    public Game gamePlay(GamePlay gamePlay) throws InvalidParamException, InvalidGameException{

        if(gamePlay.getScoreEarned()<10){
            throw new InvalidGameException("Invalid points earned");
        }

        if(!GameStorage.getInstance().getGames().containsKey(gamePlay.getGameId())){
            //game invalid
            //there is no such game to connect
            System.out.println("there is no such game to connect");
            throw new InvalidParamException("Game with provided id doesn't exist");
        }



        Game game = GameStorage.getInstance().getGames().get(gamePlay.getGameId());
        if(game.getStatus().equals(GameStatus.FINISHED)){
            //game already finished
            System.out.println("game already finished");
            throw new InvalidGameException("The Game correspond to the gameId is Finished");
        }

        if(game.getStatus().equals(GameStatus.NEW)){
            throw new InvalidGameException("The room is not full yet, Wait for everyone to join");
        }


        //add point for that player

        if(!(game.getPlayer1().getBuzzStatus().equals(BuzzStatus.BUZZED)
                ||game.getPlayer2().getBuzzStatus().equals(BuzzStatus.BUZZED)
                ||game.getPlayer3().getBuzzStatus().equals(BuzzStatus.BUZZED))){

            throw new InvalidGameException("No one buzzed yet, someone need to buzz before answering");
        }

        //compare with player's name, which mean they cannot have the same name in the same game
        if(gamePlay.getPlayer().getLogin().equals(game.getPlayer1().getLogin())){
            //player1
            if(!game.getPlayer1().getBuzzStatus().equals(BuzzStatus.BUZZED)){
                throw new InvalidGameException("Someone else buzzed before you, you are late!");
            }
            int score = game.getPlayer1().getScore();

            game.getPlayer1().setScore(score+gamePlay.getScoreEarned());
        }else if(gamePlay.getPlayer().getLogin().equals(game.getPlayer2().getLogin())){
            //player2
            if(!game.getPlayer2().getBuzzStatus().equals(BuzzStatus.BUZZED)){
                throw new InvalidGameException("Someone else buzzed before you, you are late!");
            }
            int score = game.getPlayer2().getScore();
            game.getPlayer2().setScore(score+gamePlay.getScoreEarned());
        }else {
            //player3
            if(!game.getPlayer3().getBuzzStatus().equals(BuzzStatus.BUZZED)){
                throw new InvalidGameException("Someone else buzzed before you, you are late!");
            }
            int score = game.getPlayer3().getScore();
            game.getPlayer3().setScore(score+gamePlay.getScoreEarned());
        }

        //game finish when all question is answered.
        // ++ count
        game.setCountQuestionAnswered(game.getCountQuestionAnswered()+1);

        if(game.getCountQuestionAnswered()>=30){
            // 30 questions in total
            switch(checkWinner(game)){
                case 1:
                    game.setWinner(game.getPlayer1());
                    break;
                case 2:
                    game.setWinner(game.getPlayer2());
                    break;
                case 3:
                    game.setWinner(game.getPlayer3());
                    break;
                default:
                    break;
            }
        }
/*        if (checkWinner(game.getPlayer1())) {
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
        }*/


        GameStorage.getInstance().setGames(game);
        return game;

    }

    private int checkWinner(Game game) {
        int score1 = game.getPlayer1().getScore();
        int score2 = game.getPlayer2().getScore();
        int score3 = game.getPlayer3().getScore();
        if(score1>=score2&&score1>=score3){
            return  1;
        }
        if(score2>=score1&&score2>=score3){
            return  2;
        }
        return  3;

    }


    public Map<String, Game> getAllGames() {
        return GameStorage.getInstance().getGames();
    }

    public int[] getSelectCategory(String gameId) throws InvalidGameException, InvalidParamException {
        if(!GameStorage.getInstance().getGames().containsKey(gameId)){
            //game invalid
            //there is no such game to connect
            System.out.println("there is no such game to connect");
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        Game game = GameStorage.getInstance().getGames().get(gameId);
        if(game.getStatus().equals(GameStatus.FINISHED)){
            //game already finished
            System.out.println("game already finished");
            throw new InvalidGameException("The Game correspond to the gameId is Finished");
        }

        return game.getSelectedCategory();
    }

    public Game buzz(Player player,String gameId) throws InvalidParamException, InvalidGameException {


        if(!GameStorage.getInstance().getGames().containsKey(gameId)){
            //game invalid
            //there is no such game to connect
            System.out.println("there is no such game to connect");
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        Game game = GameStorage.getInstance().getGames().get(gameId);
        if(game.getStatus().equals(GameStatus.FINISHED)){
            //game already finished
            System.out.println("game already finished");
            throw new InvalidGameException("The Game correspond to the gameId is Finished");
        }

        if(game.getStatus().equals(GameStatus.NEW)){
            throw new InvalidGameException("The room is not full yet, Wait for everyone to join");
        }


        if(game.getPlayer1().getBuzzStatus().equals(BuzzStatus.BUZZED)
                ||game.getPlayer2().getBuzzStatus().equals(BuzzStatus.BUZZED)
                ||game.getPlayer3().getBuzzStatus().equals(BuzzStatus.BUZZED)){

            throw new InvalidGameException("Someone all ready buzzed, please wait for the next time");
        }

        if(game.getPlayer1().getLogin().equals(player.getLogin())){
            game.getPlayer1().setBuzzStatus(BuzzStatus.BUZZED);
        }
        if(game.getPlayer2().getLogin().equals(player.getLogin())){
            game.getPlayer2().setBuzzStatus(BuzzStatus.BUZZED);
        }
        if(game.getPlayer3().getLogin().equals(player.getLogin())){
            game.getPlayer3().setBuzzStatus(BuzzStatus.BUZZED);
        }

        return game;


    }

    public Game buzzRelease(String gameId) throws InvalidParamException, InvalidGameException {

        if(!GameStorage.getInstance().getGames().containsKey(gameId)){
            //game invalid
            //there is no such game to connect
            System.out.println("there is no such game to connect");
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        Game game = GameStorage.getInstance().getGames().get(gameId);
        if(game.getStatus().equals(GameStatus.FINISHED)){
            //game already finished
            System.out.println("game already finished");
            throw new InvalidGameException("The Game correspond to the gameId is Finished");
        }

        if(game.getStatus().equals(GameStatus.NEW)){
            throw new InvalidGameException("The room is not full yet, Wait for everyone to join");
        }
        game.getPlayer1().setBuzzStatus(BuzzStatus.RELEASED);
        game.getPlayer2().setBuzzStatus(BuzzStatus.RELEASED);
        game.getPlayer3().setBuzzStatus(BuzzStatus.RELEASED);
        return game;
    }

    public Player getAllBuzzed(String gameId) throws InvalidParamException, InvalidGameException {
        if(!GameStorage.getInstance().getGames().containsKey(gameId)){
            //game invalid
            //there is no such game to connect
            System.out.println("there is no such game to connect");
            throw new InvalidParamException("Game with provided id doesn't exist");
        }
        Game game = GameStorage.getInstance().getGames().get(gameId);
        if(game.getStatus().equals(GameStatus.FINISHED)){
            //game already finished
            System.out.println("game already finished");
            throw new InvalidGameException("The Game correspond to the gameId is Finished");
        }

        if(game.getStatus().equals(GameStatus.NEW)){
            throw new InvalidGameException("The room is not full yet, Wait for everyone to join");
        }
        if(game.getPlayer1().getBuzzStatus().equals(BuzzStatus.BUZZED)){
            return game.getPlayer1();
        }else if(game.getPlayer2().getBuzzStatus().equals(BuzzStatus.BUZZED)){
            return game.getPlayer2();
        }else if(game.getPlayer3().getBuzzStatus().equals(BuzzStatus.BUZZED)){
            return game.getPlayer3();
        }else{
            throw new InvalidGameException("No one buzzed yet");
        }




    }
}
