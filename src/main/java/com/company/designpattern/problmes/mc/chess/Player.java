package com.company.designpattern.problmes.mc.chess;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String id;
    private String name;
    List<Game> gameHistory;

    public Player(String name) {
        this.name = name;
        this.gameHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Game> getHistory() {
        return gameHistory;
    }
}
