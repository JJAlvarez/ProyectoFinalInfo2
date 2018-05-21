package com.unis.javieralvarez.connectfour.models;

public class Game implements IGame {

    public IMove[][] Moves;
    public int Turn;

    @Override
    public void startGame() {
        this.Moves = new IMove[7][7];
        this.Turn = 0;

        for (int i = 0; i < 7; i ++) {
            for (int j = 0; j < 7; j++) {
                Move move = new Move();
                move.setPlayer(-1);
                this.Moves[i][j] = move;
            }
        }
    }

    private int getHeight() {
        return 7;
    }

    private int getWidth() {
        return 7;
    }

    @Override
    public void changeTurn() {
        this.Turn = this.Turn == 0 ? 1 : 0;
    }

    @Override
    public String getTurnPlayer() {
        return this.Turn == 0 ? "Jugador 1" : "Jugador 2";
    }

    @Override
    public boolean checkWinner() {
        // verticalCheck
        for (int j = 0; j<getHeight()-3 ; j++ ){
            for (int i = 0; i<getWidth(); i++){
                if (this.Moves[i][j].getPlayer() == getTurn() && this.Moves[i][j+1].getPlayer() == getTurn()
                        && this.Moves[i][j+2].getPlayer() == getTurn() && this.Moves[i][j+3].getPlayer() == getTurn()){
                    return true;
                }
            }
        }
        //horizontalCheck
        for (int i = 0; i<getWidth()-3 ; i++ ){
            for (int j = 0; j<this.getHeight(); j++){
                if (this.Moves[i][j].getPlayer() == getTurn() && this.Moves[i+1][j].getPlayer() == getTurn()
                        && this.Moves[i+2][j].getPlayer() == getTurn() && this.Moves[i+3][j].getPlayer() == getTurn()){
                    return true;
                }
            }
        }
        // ascendingDiagonalCheck
        for (int i=3; i<getWidth(); i++){
            for (int j=0; j<getHeight()-3; j++){
                if (this.Moves[i][j].getPlayer() == getTurn() && this.Moves[i-1][j+1].getPlayer() == getTurn()
                        && this.Moves[i-2][j+2].getPlayer() == getTurn() && this.Moves[i-3][j+3].getPlayer() == getTurn())
                    return true;
            }
        }
        // descendingDiagonalCheck
        for (int i=3; i<getWidth(); i++){
            for (int j=3; j<getHeight(); j++){
                if (this.Moves[i][j].getPlayer() == getTurn() && this.Moves[i-1][j-1].getPlayer() == getTurn()
                        && this.Moves[i-2][j-2].getPlayer() == getTurn() && this.Moves[i-3][j-3].getPlayer() == getTurn())
                    return true;
            }
        }
        return false;
    }

    @Override
    public void restartGame() {
        this.Moves = new IMove[7][7];
        this.Turn = 0;
    }

    @Override
    public int makeMove(int x) {
        IMove move = new Move();
        int y = 6;
        while (true) {
            if (y < 0)
                break;
            
            if (Moves[x - 1][y].getPlayer() == -1)
                break;
            y--;
        }
        move.setPosittion(x - 1, y, getTurn());
        if (checkValidMove(x - 1, y)) {
            Moves[x - 1][y] = move;
            return y;
        }

        return -1;
    }

    @Override
    public boolean checkValidMove(int x, int y) {
        return y >= 0;
    }

    @Override
    public int getTurn() {
        return this.Turn;
    }
}
