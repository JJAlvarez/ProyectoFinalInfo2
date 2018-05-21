package com.unis.javieralvarez.connectfour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.unis.javieralvarez.connectfour.R;
import com.unis.javieralvarez.connectfour.models.IGame;
import com.unis.javieralvarez.connectfour.presenter.IStartPresenter;
import com.unis.javieralvarez.connectfour.presenter.StartPresenter;
import com.unis.javieralvarez.connectfour.view.IStartView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IStartView {

    private IStartPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.presenter = new StartPresenter(this);
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
    public void launchManual() {
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @OnClick({R.id.btn_pair, R.id.btn_manual})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_pair:
                startGame();
                break;
            case R.id.btn_manual:
                launchManual();
                break;
        }
    }
}
