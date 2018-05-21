package com.unis.javieralvarez.connectfour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.unis.javieralvarez.connectfour.R;
import com.unis.javieralvarez.connectfour.presenter.ISplashPresenter;
import com.unis.javieralvarez.connectfour.presenter.SplashPresenter;
import com.unis.javieralvarez.connectfour.view.ISplashView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements ISplashView {

    @BindView(R.id.progressBarRestaurants)
    ProgressBar progressBarRestaurants;

    private ISplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        this.presenter = new SplashPresenter(this);
        showProgress();
    }

    @Override
    public void showProgress() {
        progressBarRestaurants.setVisibility(View.VISIBLE);
        presenter.startMain();
    }

    @Override
    public void hideProgress() {
        progressBarRestaurants.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        }, 2250);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
        