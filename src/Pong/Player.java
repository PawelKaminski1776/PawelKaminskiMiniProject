package Pong;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int wins;
    public Player(String name){
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }
}
