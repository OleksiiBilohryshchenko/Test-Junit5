package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameEngineTest {

    @Mock
    private Player playerOne;

    @Mock
    private Player playerTwo;

    private GameEngine gameEngine;

    @BeforeEach
    void setUp() {
        gameEngine = new GameEngine(playerOne,playerTwo);
    }

    @Test
    void shouldSimulatePlayerMoves(){
        when(playerOne.makeMove()).thenReturn(Move.ROCK);
        when(playerTwo.makeMove()).thenReturn(Move.SCISSORS);

        gameEngine.playRound();

        assertEquals(Result.PLAYER_ONE_WINS,gameEngine.decideWinner(),
                "Player one wins!");
    }

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
