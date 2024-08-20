package com.company.designpattern.problmes.mc.chess.models;

import com.company.designpattern.problmes.mc.chess.Cell;
import com.company.designpattern.problmes.mc.chess.Chessboard;
import com.company.designpattern.problmes.mc.chess.PieceColor;

public class King extends Piece {
    public King(PieceColor color) {
        super(color);
    }

    @Override
    public String getName() {
        return (color==PieceColor.Black ? "B" : "W") + "K";
    }

    @Override
    public boolean validMove(Cell start, Cell end, Chessboard chessboard) {
        int x =  start.getXPosition();
        int y =  start.getYPosition();
        int dx = end.getXPosition();
        int dy = end.getYPosition();

        if(end.getPiece()==null || !end.getPiece().color.equals(color)) {
            if((x==dx && y+1==dy) || (x==dx && y-1==dy) || (x+1==dx && y==dy) || (x-1==dx && y==dy))
                return true;
        }

        return false;
    }
}
