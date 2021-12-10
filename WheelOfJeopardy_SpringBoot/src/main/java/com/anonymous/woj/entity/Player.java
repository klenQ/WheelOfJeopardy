package com.anonymous.woj.entity;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/16
 */
public class Player {
    private String login;
    private int score;
    private BuzzStatus buzzStatus;

    public Player() {
        this.score = 0;
        this.buzzStatus = BuzzStatus.NONE;

    }

    public Player(String login) {
        this.login = login;
        this.score = 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public BuzzStatus getBuzzStatus() {
        return buzzStatus;
    }

    public void setBuzzStatus(BuzzStatus buzzStatus) {
        this.buzzStatus = buzzStatus;
    }

    @Override
    public String toString() {
        return "Player{" +
                "login='" + login + '\'' +
                ", score=" + score +
                ", buzzStatus=" + buzzStatus +
                '}';
    }
}
