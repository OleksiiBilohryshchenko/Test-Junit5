package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        gameEngine = new GameEngine(playerOne, playerTwo);
    }

    @Test
    void shouldSimulatePlayerMoves() {
        when(playerOne.makeMove()).thenReturn(Move.ROCK);
        when(playerTwo.makeMove()).thenReturn(Move.SCISSORS);

        Result result = gameEngine.playRound();

        assertEquals(Result.PLAYER_ONE_WINS, result,
                "Player one should win when ROCK beats SCISSORS!");
    }

    @Test
    void shouldHandleDrawWhenSameMoves() {
        when(playerOne.makeMove()).thenReturn(Move.PAPER);
        when(playerTwo.makeMove()).thenReturn(Move.PAPER);

        Result result = gameEngine.playRound();

        assertEquals(Result.DRAW, result,
                "GameEngine should return DRAW when both players make the same move.");
    }

    @Test
    void shouldHandleExceptionWhenPlayerMoveIsNull() {
        when(playerOne.makeMove()).thenReturn(null);

        Exception exception = assertThrows(GameException.class, () -> gameEngine.playRound(),
                "GameEngine should throw GameException when player's move is null");

        assertEquals("Player's move cannot be null.", exception.getMessage(),
                "GameEngine should provide a meaningful error message.");
    }

    @Test
    void shouldTrackScoresCorrectly() {
        when(playerOne.makeMove()).thenReturn(Move.ROCK);
        when(playerTwo.makeMove()).thenReturn(Move.SCISSORS);

        gameEngine.playRound();

        assertEquals(1, gameEngine.getPlayerOneScore(), "Player One's score should increase to 1.");
        assertEquals(0, gameEngine.getPlayerTwoScore(), "Player Two's score should remain 0.");
    }

    @Test
    void shouldDeclareWinnerAfterThreeRounds() {
        when(playerOne.makeMove()).thenReturn(Move.ROCK, Move.PAPER, Move.SCISSORS);
        when(playerTwo.makeMove()).thenReturn(Move.SCISSORS, Move.ROCK, Move.PAPER);

        gameEngine.playRound();
        gameEngine.playRound();
        gameEngine.playRound();

        String overallWinner = gameEngine.determineOverallWinner();

        assertEquals("Player One Wins the Game!", overallWinner,
                "GameEngine should declare Player One as the overall winner.");
    }
}
