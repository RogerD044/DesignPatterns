package com.company.designpattern.problmes.mc.chess;

import java.util.HashMap;

public class PlayerService {
    private HashMap<String, Player> players;

    public PlayerService() {
        this.players = new HashMap<>();
    }

    public Player registerPlayer(String username) throws Exception {
        if(players.containsKey(username))
            throw new Exception("Username already exists");

        players.put(username,new Player(username));
        return players.get(username);
    }
}
