package com.example.kalamba.model;



import com.example.kalamba.model.Action;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActionEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    public void setAction(Action action){
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