package com.company.designpattern.problmes.mc.chess.models;

import com.company.designpattern.problmes.mc.chess.Cell;
import com.company.designpattern.problmes.mc.chess.Chessboard;
import com.company.designpattern.problmes.mc.chess.PieceColor;

public abstract class Piece {
    PieceColor color;

    public Piece(PieceColor color) {
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    public abstract String getName();

    public abstract boolean validMove(Cell start, Cell end, Chessboard chessboard);
}
