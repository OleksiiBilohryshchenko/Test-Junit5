package com.example;

import java.util.HashMap;
import java.util.Map;

public class GameEngine {

    private final Player playerOne;
    private final Player playerTwo;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private int roundCount = 0;
    private final int totalRounds = 3;

    public GameEngine(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Result playRound() {
        Move moveOne = playerOne.makeMove();
        Move moveTwo = playerTwo.makeMove();

        if (moveOne == null || moveTwo == null) {
            throw new GameException("Player's move cannot be null.");
        }

        roundCount++;
        Result roundResult = determineRoundWinner(moveOne, moveTwo);
        updateScores(roundResult);

        return roundResult;
    }

    private Result determineRoundWinner(Move moveOne, Move moveTwo) {
        if (moveOne == moveTwo) {
            return Result.DRAW;
        }

        Map<Move, Move> winningMoves = new HashMap<>();
        winningMoves.put(Move.ROCK, Move.SCISSORS);
        winningMoves.put(Move.SCISSORS, Move.PAPER);
        winningMoves.put(Move.PAPER, Move.ROCK);

        return winningMoves.get(moveOne) == moveTwo ? Result.PLAYER_ONE_WINS : Result.PLAYER_TWO_WINS;
    }

    private void updateScores(Result roundResult) {
        if (roundResult == Result.PLAYER_ONE_WINS) {
            playerOneScore++;
        } else if (roundResult == Result.PLAYER_TWO_WINS) {
            playerTwoScore++;
        }
    }

    public String determineOverallWinner() {
        if (roundCount < totalRounds) {
            return "Game is not over yet.";
        }
        return playerOneScore > playerTwoScore ? "Player One Wins the Game!" :
                playerOneScore < playerTwoScore ? "Player Two Wins the Game!" :
                        "The game is a Draw!";
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
}
