package com.example;

import java.util.Random;

public class AIPlayer implements Player {

    @Override
    public Move makeMove() {
        Move[] moves = Move.values();
        return moves[new Random().nextInt(moves.length)];
    }
}
