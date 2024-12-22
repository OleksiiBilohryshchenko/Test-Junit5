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
    void shouldHandleDrawWhenSameMoves(){
        when(playerOne.makeMove()).thenReturn(Move.PAPER);
        when(playerTwo.makeMove()).thenReturn(Move.PAPER);

        gameEngine.playRound();
        assertEquals(Result.DRAW,gameEngine.decideWinner(),
                "GameEngine should return draw when both players making the same move.");
    }

}
