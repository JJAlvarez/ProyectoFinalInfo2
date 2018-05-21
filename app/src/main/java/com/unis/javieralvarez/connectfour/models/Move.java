package com.unis.javieralvarez.connectfour.models;

public class Move implements IMove {

    public int X;
    public int Y;
    public int player;

    @Override
    public void setPosittion(int x, int y, int player) {
        this.X = x;
        this.Y = y;
        this.player = player;
    }

    @Override
    public int getXPosittion() {
        return this.X;
    }

    @Override
    public int getYPosition() {
        return this.Y;
    }

    @Override
    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) { this.player = player; }
}
