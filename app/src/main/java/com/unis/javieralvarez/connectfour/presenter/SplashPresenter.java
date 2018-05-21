package com.unis.javieralvarez.connectfour.presenter;

import com.unis.javieralvarez.connectfour.view.ISplashView;

public class SplashPresenter implements ISplashPresenter {

    private ISplashView view;

    public SplashPresenter(ISplashView view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        if (this.view != null)
            this.view = null;
    }

    @Override
    public void startMain() {
        this.view.hideProgress();
        this.view.showMain();
    }
}
