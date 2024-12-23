package com.example;

public class HumanPlayer implements Player {

    private Move move;

    @Override
    public Move makeMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
