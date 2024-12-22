package com.example;

public class GameEngine {

    private Move lastMove;

    public void acceptMove (Move move) {
        this.lastMove = move;
    }

    public Move getLastMove () {
        return lastMove;
    }

}
