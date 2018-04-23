package com.unis.javieralvarez.connectfour.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.unis.javieralvarez.connectfour.R;
import com.unis.javieralvarez.connectfour.models.IGame;
import com.unis.javieralvarez.connectfour.models.IMove;
import com.unis.javieralvarez.connectfour.models.Move;
import com.unis.javieralvarez.connectfour.view.IConnectFourGameView;

public class ConnectFourGameActivity extends AppCompatActivity implements IConnectFourGameView{

    private IGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four_game);

        startGame((IGame) getIntent().getExtras().get("GAME"));
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void initializeGame() {
        game.startGame();
    }

    @Override
    public void makeMove(int x, int y) {
        if (checkMove(x, y))
        this.game.makeMove(x, y);
    }

    @Override
    public boolean checkMove(int x, int y) {
        return this.game.checkValidMove(x, y);
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

    }

    @Override
    public void startGame(IGame game) {
        this.game = game;
        initializeGame();
    }

    public IGame getGame() {
        return this.game;
    }
}
