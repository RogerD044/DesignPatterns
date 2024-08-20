package com.company.designpattern.problmes.mc.chess;

import com.company.designpattern.problmes.mc.chess.models.Piece;

public class Cell {
    private int x;
    private int y;
    private Piece piece;

    public Cell(int i, int j) {
        this.x = i;
        this.y = j;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public void print() {
        if(piece==null)
            System.out.print("-- ");
        else
            System.out.print(piece.getName()+" ");
    }
}
