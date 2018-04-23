package com.unis.javieralvarez.connectfour.models;

import java.io.Serializable;

public interface IGame extends Serializable {

    void startGame();
    void changeTurn();
    String getTurnPlayer();
    boolean checkWinner();
    void restartGame();
    void makeMove(int x, int y);
    boolean checkValidMove(int x, int y);
    int getTurn();
}
