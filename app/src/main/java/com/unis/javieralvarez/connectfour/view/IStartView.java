package com.unis.javieralvarez.connectfour.view;

import com.unis.javieralvarez.connectfour.models.IGame;

/**
 * Created by Javier Alvarez on 22/04/2018.
 */

public interface IStartView {

    void showProgressBar();
    void hideProgressBar();
    void startGame();
    void launchGame(IGame game);
}
