package com.anonymous.woj.controller;

import com.anonymous.woj.bean.Msg;
import com.anonymous.woj.entity.Game;
import com.anonymous.woj.entity.GamePlay;
import com.anonymous.woj.entity.Player;
import com.anonymous.woj.exception.InvalidGameException;
import com.anonymous.woj.exception.InvalidParamException;
import com.anonymous.woj.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/13
 */

@RestController
@RequestMapping("/game")
public class GameController {

    /*Buzz in
        Spin the wheel / choose category
        Enter player name
        Start/join game
        Invite player -> returns session ID */

    @Autowired
    private GameService gameService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/getAllGames")
    public Msg getAllGames() {

        //a player contain a login name with 0 score.

        Map<String, Game> games = gameService.getAllGames();
        return Msg.success().add("games",games);

    }

    @PostMapping("/start")
    public Msg start(@RequestBody Player player) {

        //a player contain a login name with 0 score.

        Game game = gameService.createGame(player);
        return Msg.success().add("game",game);

    }

    @PostMapping("/connect")
    public Msg connect(@RequestBody Player player, String gameId){
        System.out.println("Player-"+player +"::"+ gameId);
        Game game = null;
        try {
            game = gameService.connectToGame(player, gameId);
        } catch (InvalidParamException e) {
            return Msg.fail(e.getMessage());
        } catch (InvalidGameException e){
            return Msg.fail(e.getMessage());
        }
        return Msg.success().add("game",game);
    }

    @PostMapping("/gameplay")
    public Msg gamePlay(@RequestBody GamePlay gamePlay){
        System.out.println("Player-"+gamePlay.getPlayer() +"::"+gamePlay.getScoreEarned()+"::"+ gamePlay.getGameId());
        //GamePlay contain Player, game ID, and the score earned for that player
        Game game = null;
        try {
            game = gameService.gamePlay(gamePlay);
        } catch (InvalidParamException e) {
            return Msg.fail(e.getMessage());
        } catch (InvalidGameException e) {
            return Msg.fail(e.getMessage());
        }
        simpMessagingTemplate.convertAndSend("/topic/game-progress" + game.getGameId(),game);
        return Msg.success().add("game",game);
    }

    @PostMapping("/selectCategories")
    public Msg selectCategories(@RequestBody int[] categories, String gameId){
        Game game = null;
        try {
            game = gameService.selectCategory(categories,gameId);
        } catch (InvalidParamException e) {
            return Msg.fail(e.getMessage());
        } catch (InvalidGameException e) {
            return Msg.fail(e.getMessage());
        }
        return Msg.success().add("game", game);
    }
    @GetMapping("/getSelectedCategories")
    public Msg selectCategories(String gameId){
        int[] categoriesIds = null;
        try {
            categoriesIds = gameService.getSelectCategory(gameId);
        } catch (InvalidParamException e) {
            return Msg.fail(e.getMessage());
        } catch (InvalidGameException e) {
            return Msg.fail(e.getMessage());
        }
        return Msg.success().add("categoriesIds", categoriesIds);
    }



}
