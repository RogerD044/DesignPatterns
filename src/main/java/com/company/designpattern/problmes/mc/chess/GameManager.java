package com.company.designpattern.problmes.mc.chess;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GameManager {
    private AtomicInteger id;
    HashMap<Integer, Game> games;

    public GameManager() {
        this.id = new AtomicInteger(0);
        this.games = new HashMap<Integer, Game>();
    }

    public Game createGame(Player p1, Player p2) {
        Game game = new Game(p1, p2);
        games.put(id.get(), game);
        return game;
    }

    public void makeMove(Cell start, Cell end, Game game, Player p) {
        games.get(0).move(start,end,p);
    }


}
