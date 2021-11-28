package com.anonymous.woj.entity;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/16
 */

public class Game {
    private String gameId;
    private Player player1;
    private Player player2;
    private Player player3;
    private GameStatus status;
    private Player winner;
    private Integer countQuestionAnswered;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Integer getCountQuestionAnswered() {
        return countQuestionAnswered;
    }

    public void setCountQuestionAnswered(Integer countQuestionAnswered) {
        this.countQuestionAnswered = countQuestionAnswered;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", countQuestionAnswered='" + countQuestionAnswered + '\'' +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", player3=" + player3 +
                ", status=" + status +
                ", winner=" + winner +
                '}';
    }
}
