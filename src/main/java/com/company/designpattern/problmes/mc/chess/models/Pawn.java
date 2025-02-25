package com.company.designpattern.problmes.mc.chess.models;

import com.company.designpattern.problmes.mc.chess.Cell;
import com.company.designpattern.problmes.mc.chess.Chessboard;
import com.company.designpattern.problmes.mc.chess.PieceColor;

public class Pawn extends Piece{

    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public String getName() {
        return (color==PieceColor.Black ? "B" : "W") + "P";
    }

    @Override
    public boolean validMove(Cell start, Cell end, Chessboard chessboard) {
        int x =  start.getXPosition();
        int y =  start.getYPosition();
        int dx = end.getXPosition();
        int dy = end.getYPosition();

        if(color.equals(PieceColor.Black) && (end.getPiece()==null || !end.getPiece().color.equals(color))) {
            // Move Down
            if((x+1==dx && y==dy) || (x+1==dx && y+1==dy) || (x+1==dx && y-1==dy))
                return true;

        } else if(color.equals(PieceColor.White) && (end.getPiece()==null || !end.getPiece().color.equals(color)))  {
            // Move Up
            if((x-1==dx && y==dy) || (x-1==dx && y+1==dy) || (x-1==dx && y-1==dy))
                return true;

        }

        return false;
    }
}
