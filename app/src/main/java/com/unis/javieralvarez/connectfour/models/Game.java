package com.unis.javieralvarez.connectfour.models;

public class Game implements IGame {

    public IMove[][] Moves;
    public int Turn;

    @Override
    public void startGame() {
        this.Moves = new IMove[7][6];
        this.Turn = 0;
    }

    @Override
    public void changeTurn() {
        this.Turn = this.Turn == 0 ? 1 : 0;
    }

    @Override
    public String getTurnPlayer() {
        return this.Turn == 0 ? "Jugador 1" : "Jugador 2";
    }

    @Override
    public boolean checkWinner() {
        return false;
    }

    @Override
    public void restartGame() {
        this.Moves = new IMove[7][6];
        this.Turn = 0;
    }

    @Override
    public void makeMove(int x, int y) {
        IMove move = new Move();
        move.setPosittion(x, y);
        Moves[x][y] = move;
        this.changeTurn();
    }

    @Override
    public boolean checkValidMove(int x, int y) {
        return true;
    }

    @Override
    public int getTurn() {
        return this.Turn;
    }
}
