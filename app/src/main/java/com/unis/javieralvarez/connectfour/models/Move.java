package com.unis.javieralvarez.connectfour.models;

/**
 * Created by Javier Alvarez on 22/04/2018.
 */

public class Move implements IMove {

    public int X;
    public int Y;

    @Override
    public void setPosittion(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public int getXPosittion() {
        return this.X;
    }

    @Override
    public int getYPosition() {
        return this.Y;
    }
}
