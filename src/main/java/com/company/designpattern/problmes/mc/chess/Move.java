package com.company.designpattern.problmes.mc.chess;

import com.company.designpattern.problmes.mc.chess.models.Piece;

public class Move {
    private Player player;
    private Piece piece;
    private Cell start;
    private Cell end;

    public Move(Player player, Cell start, Cell end, Piece piece) {
        this.start = start;
        this.end = end;
        this.player = player;
        this.piece = piece;
    }
}
