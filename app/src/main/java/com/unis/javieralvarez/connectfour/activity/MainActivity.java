package com.unis.javieralvarez.connectfour.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.unis.javieralvarez.connectfour.R;
import com.unis.javieralvarez.connectfour.models.Game;
import com.unis.javieralvarez.connectfour.models.IGame;
import com.unis.javieralvarez.connectfour.presenter.IStartPresenter;
import com.unis.javieralvarez.connectfour.presenter.StartPresenter;
import com.unis.javieralvarez.connectfour.view.IStartView;

public class MainActivity extends AppCompatActivity implements IStartView{

    private IStartPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new StartPresenter(this);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void startGame() {
        this.presenter.initializeGame();
    }

    @Override
    public void launchGame(IGame game) {
        Intent intent = new Intent(this, ConnectFourGameActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Bundle bundle = new Bundle();
        bundle.putSerializable("GAME", game);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
