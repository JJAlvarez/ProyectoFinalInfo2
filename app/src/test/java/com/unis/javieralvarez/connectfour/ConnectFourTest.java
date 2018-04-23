package com.unis.javieralvarez.connectfour;

import com.unis.javieralvarez.connectfour.activity.ConnectFourGameActivity;
import com.unis.javieralvarez.connectfour.activity.MainActivity;
import com.unis.javieralvarez.connectfour.models.Game;
import com.unis.javieralvarez.connectfour.models.IGame;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectFourTest {

    @Test
    public void check_initialize_turn() throws Exception {
        IGame game = new Game();
        game.startGame();
        assertEquals(0, game.getTurn());
    }

    @Test
    public void check_initialize_table_move() throws Exception {
        IGame game = new Game();
        game.startGame();
        game.checkValidMove(0, 0);
        assertEquals(true, game.checkValidMove(0, 0));
    }

    @Test
    public void check_turn_change() throws Exception {
        IGame game = new Game();
        game.changeTurn();
        assertEquals(1, game.getTurn());
    }

    @Test
    public void check_make_move_change_turn() throws Exception {
        IGame game = new Game();
        game.startGame();
        game.makeMove(0, 0);
        assertEquals(1, game.getTurn());
    }

    @Test
    public void initialize_game() throws Exception {
        IGame game = new Game();
        ConnectFourGameActivity activity = new ConnectFourGameActivity();
        activity.startGame(game);
        activity.makeMove(0,0);

        assertEquals(true, ((Game)activity.getGame()).Moves[0][0] != null);
    }

    @Test
    public void restart_game() throws Exception {
        IGame game = new Game();
        ConnectFourGameActivity activity = new ConnectFourGameActivity();
        activity.startGame(game);
        activity.makeMove(0,0);

        activity.restartGame();

        assertEquals(true, ((Game)activity.getGame()).Moves[0][0] == null);
    }
}