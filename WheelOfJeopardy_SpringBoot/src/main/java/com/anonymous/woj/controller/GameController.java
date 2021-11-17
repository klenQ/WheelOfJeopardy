package com.anonymous.woj.controller;

import com.anonymous.woj.bean.Game;
import com.anonymous.woj.bean.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

/*    private final GameService gameService;
    private final SimpMessagingTemplate simpMessagingTemplate;*/

    @PostMapping("/start")
    public ResponseEntity<Game> start(@RequestBody Player player) {
/*        log.info("start game request: {}", player);
        return ResponseEntity.ok(gameService.createGame(player));*/
        return null;
    }

    @PostMapping("/connect")
    public ResponseEntity<Game> connect(/*@RequestBody ConnectRequest request*/){
/*        log.info("connect request: {}", request);
        return ResponseEntity.ok(gameService.connectToGame(request.getPlayer(), request.getGameId()));*/
        return null;
    }

    @PostMapping("/gameplay")
    public ResponseEntity<Game> gamePlay(/*@RequestBody GamePlay request*/){
/*        log.info("gameplay: {}", request);
        Game game = gameService.gamePlay(request);
        simpMessagingTemplate.convertAndSend("/topic/game-progress/" + game.getGameId(), game);
        return ResponseEntity.ok(game);*/
        return null;
    }


}
