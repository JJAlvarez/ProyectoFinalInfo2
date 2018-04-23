package com.unis.javieralvarez.connectfour.presenter;

import com.unis.javieralvarez.connectfour.models.Game;
import com.unis.javieralvarez.connectfour.models.IGame;
import com.unis.javieralvarez.connectfour.view.IStartView;

public class StartPresenter implements IStartPresenter {

    private IStartView view;

    public StartPresenter(IStartView view) {
        this.view = view;
    }

    @Override
    public void initializeGame() {
        if (view != null) {
            IGame game = new Game();
            view.launchGame(game);
        }
    }

    @Override
    public void onDestroy() {
        if (view != null) {
            view = null;
        }
    }

}
