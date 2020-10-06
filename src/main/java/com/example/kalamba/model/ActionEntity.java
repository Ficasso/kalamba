package com.example.kalamba.model;

import javax.persistence.*;

@Entity
@Table(name="actions")
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer gameId;
    private Action action;

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public Action getAction() {
        return action;
    }
}