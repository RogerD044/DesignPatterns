package com.company.designpattern.problmes.mc.chess;

import com.company.designpattern.problmes.mc.chess.models.*;

public class Chessboard {
    Cell[][] cells;

    public Chessboard() {
        this.cells = new Cell[8][8];
        for(int i=0;i<8;++i) {
            for(int j=0;j<8;++j) {
                cells[i][j] = new Cell(i,j);
            }
        }

        initializeChessboard();
    }

    private void initializeChessboard() {
        // Black Pieces
        cells[0][0].setPiece(new Rookie(PieceColor.Black));
        cells[0][7].setPiece(new Rookie(PieceColor.Black));
        cells[0][1].setPiece(new Horse(PieceColor.Black));
        cells[0][6].setPiece(new Horse(PieceColor.Black));
        cells[0][2].setPiece(new Bishop(PieceColor.Black));
        cells[0][5].setPiece(new Bishop(PieceColor.Black));
        cells[0][3].setPiece(new Queen(PieceColor.Black));
        cells[0][4].setPiece(new King(PieceColor.Black));
        for(int i=0;i<8;++i) {
            cells[1][i].setPiece(new Pawn(PieceColor.Black));
        }

        // White Pieces
        cells[7][0].setPiece(new Rookie(PieceColor.White));
        cells[7][7].setPiece(new Rookie(PieceColor.White));
        cells[7][1].setPiece(new Horse(PieceColor.White));
        cells[7][6].setPiece(new Horse(PieceColor.White));
        cells[7][2].setPiece(new Bishop(PieceColor.White));
        cells[7][5].setPiece(new Bishop(PieceColor.White));
        cells[7][3].setPiece(new Queen(PieceColor.White));
        cells[7][4].setPiece(new King(PieceColor.White));
        for(int i=0;i<8;++i) {
            cells[6][i].setPiece(new Pawn(PieceColor.White));
        }
    }

    public void print() {
        for(int i=0;i<8;++i) {
            for(int j=0;j<8;++j) {
                cells[i][j].print();
            }
            System.out.println();
        }
    }

}
