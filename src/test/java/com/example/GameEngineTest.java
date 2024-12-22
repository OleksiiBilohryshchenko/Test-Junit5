package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameEngineTest {

    @Test
    void shouldAcceptPlayerMoves(){
        GameEngine gameEngine = new GameEngine();
        gameEngine.acceptMove(Move.ROCK);
        assertEquals(Move.ROCK, gameEngine.getLastMove(),
                "GameEngine should accept and store the player's move");
    }

}
