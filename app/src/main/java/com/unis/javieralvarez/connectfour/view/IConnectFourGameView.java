package com.unis.javieralvarez.connectfour.view;

import com.unis.javieralvarez.connectfour.models.IGame;

/**
 * Created by Javier Alvarez on 22/04/2018.
 */

public interface IConnectFourGameView {

    void initializeGame();
    int makeMove(int x);
    void showWinner();
    void restartGame();
    void exitGame();
    void startGame(IGame game);

}
