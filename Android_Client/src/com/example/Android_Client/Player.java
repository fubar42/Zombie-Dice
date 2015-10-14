package com.example.Android_Client;

import java.io.Serializable;

/**
 * Created by s213391244 on 10/13/2015.
 */
public class Player implements Serializable {
    private String handle;
    private int score;
    public Player(String handle){
        this.handle = handle;
        score = 0;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
