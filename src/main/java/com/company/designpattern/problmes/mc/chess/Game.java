package com.company.designpattern.problmes.mc.chess;

import com.company.designpattern.problmes.mc.chess.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Player white;
    Player black;
    GameStatus gameStatus;
    List<Move> moves;
    Player winner;
    Chessboard board;
    Player currentPlayer;
    List<Piece> blackCaptured;
    List<Piece> whiteCaptured;

    public Game(Player p1, Player p2) {
        initialize(p1,p2);
    }

    private void initialize(Player p1, Player p2) {
        int rand = (new Random()).nextInt()%2;
        if(rand%2==0) {
            this.white = p1;
            this.black = p2;
        } else {
            this.white = p2;
            this.black = p1;
        }

        this.gameStatus = GameStatus.ACTIVE;
        this.moves = new ArrayList<>();
        this.board = new Chessboard();
        this.currentPlayer = white;
        this.blackCaptured = new ArrayList<>();
        this.whiteCaptured = new ArrayList<>();
    }

    public void move(Cell start, Cell end, Player p) {
        if(p!=currentPlayer || start.getPiece()==null || start.getPiece().getColor()==end.getPiece().getColor() || !start.getPiece().validMove(start,end,board)) {
            System.out.println("Wrong Move");
            return;
        }

        // Capture
        if(end.getPiece()!=null) {
            Piece captured = end.getPiece();
            if(captured.getColor().equals(PieceColor.Black))
                blackCaptured.add(captured);
            else
                whiteCaptured.add(captured);
        }

        end.setPiece(start.getPiece());
        start.setPiece(null);

        moves.add(new Move(currentPlayer,start,end, start.getPiece()));

        // Change Player
        if(currentPlayer==white)
            currentPlayer = black;
        else
            currentPlayer = white;
    }



}
