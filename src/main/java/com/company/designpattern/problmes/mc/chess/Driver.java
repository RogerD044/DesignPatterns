package com.company.designpattern.problmes.mc.chess;

public class Driver {
    public static void main(String[] args) throws Exception {
        PlayerService playerService = new PlayerService();
        Player p1 = playerService.registerPlayer("p1");
        Player p2 = playerService.registerPlayer("p2");

        GameManager gameManager = new GameManager();
        Game game = gameManager.createGame(p1,p2);

        game.board.print();

    }
}
