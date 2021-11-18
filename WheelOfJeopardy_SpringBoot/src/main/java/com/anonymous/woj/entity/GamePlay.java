package com.anonymous.woj.entity;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/18
 */
public class GamePlay {
    private String gameId;
    private int scoreEarned;
    private Player player;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getScoreEarned() {
        return scoreEarned;
    }

    public void setScoreEarned(int scoreEarned) {
        this.scoreEarned = scoreEarned;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "GamePlay{" +
                "gameId='" + gameId + '\'' +
                ", scoreEarned=" + scoreEarned +
                ", player=" + player +
                '}';
    }
}
