package com.unis.javieralvarez.connectfour.models;

import java.io.Serializable;

public interface IGame extends Serializable {

    void startGame();
    void changeTurn();
    String getTurnPlayer();
    boolean checkWinner();
    void restartGame();
    int makeMove(int x);
    boolean checkValidMove(int x, int y);
    int getTurn();
}
