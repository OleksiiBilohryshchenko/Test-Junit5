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

    @Test
    void shouldDecideWinnerBasedOnMoves() {
        GameEngine gameEngine = new GameEngine();
        gameEngine.acceptMove(Move.ROCK);      // Player 1 chooses ROCK
        gameEngine.acceptMove(Move.SCISSORS); // Player 2 chooses SCISSORS

        // Assert that Player 1 wins when ROCK beats SCISSORS
        assertEquals(Result.PLAYER_ONE_WINS, gameEngine.decideWinner(),
                "GameEngine should decide the winner based on the moves.");
    }

}
