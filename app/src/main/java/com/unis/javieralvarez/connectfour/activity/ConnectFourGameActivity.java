package com.unis.javieralvarez.connectfour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.unis.javieralvarez.connectfour.R;
import com.unis.javieralvarez.connectfour.models.IGame;
import com.unis.javieralvarez.connectfour.view.IConnectFourGameView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConnectFourGameActivity extends AppCompatActivity implements IConnectFourGameView {

    @BindView(R.id.fila1)
    LinearLayout fila1;
    @BindView(R.id.fila2)
    LinearLayout fila2;
    @BindView(R.id.fila3)
    LinearLayout fila3;
    @BindView(R.id.fila4)
    LinearLayout fila4;
    @BindView(R.id.fila5)
    LinearLayout fila5;
    @BindView(R.id.fila6)
    LinearLayout fila6;
    @BindView(R.id.fila7)
    LinearLayout fila7;

    private IGame game;
    private boolean keepPlaying = true;
    private LinearLayout[] filas = new LinearLayout[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four_game);
        ButterKnife.bind(this);

        startGame((IGame) getIntent().getExtras().get("GAME"));
        saveFilas();
    }

    private void saveFilas() {
        filas[0] = fila1;
        filas[1] = fila2;
        filas[2] = fila3;
        filas[3] = fila4;
        filas[4] = fila5;
        filas[5] = fila6;
        filas[6] = fila7;
    }

    @Override
    public void initializeGame() {
        game.startGame();
    }

    @Override
    public int makeMove(int x) {
        return this.game.makeMove(x);
    }

    @Override
    public void showWinner() {
        Toast.makeText(this, getString(R.string.game_winner) + game.getTurnPlayer(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void restartGame() {
        this.game.restartGame();
    }

    @Override
    public void exitGame() {
        finish();
        System.exit(0);
    }

    @Override
    public void startGame(IGame game) {
        this.game = game;
        initializeGame();
    }

    public IGame getGame() {
        return this.game;
    }

    @OnClick({R.id.btn_col1, R.id.btn_col2, R.id.btn_col3, R.id.btn_col4, R.id.btn_col5, R.id.btn_col6, R.id.btn_col7})
    public void onViewClicked(View view) {

        if (!keepPlaying)
            return;

        int column = 0;
        switch (view.getId()) {
            case R.id.btn_col1:
                column = 1;
                break;
            case R.id.btn_col2:
                column = 2;
                break;
            case R.id.btn_col3:
                column = 3;
                break;
            case R.id.btn_col4:
                column = 4;
                break;
            case R.id.btn_col5:
                column = 5;
                break;
            case R.id.btn_col6:
                column = 6;
                break;
            case R.id.btn_col7:
                column = 7;
                break;
        }

        int fila = makeMove(column);
        if (game.checkWinner()) {
            keepPlaying = false;
            showWinner();
        }

        if (fila != -1) {
            game.changeTurn();
            setCoin(fila, column - 1);
        }
    }

    private void setCoin(int fil, int col) {
        View fila = filas[fil].getChildAt(col);
        fila = ((LinearLayout) fila).getChildAt(0);
        ((ImageView) fila).setImageResource(game.getTurn() == 0 ?
                R.drawable.red : R.drawable.blue);
    }

    @OnClick(R.id.btn_regresar)
    public void onViewClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
    }

    @OnClick(R.id.btn_restart)
    public void restart() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
