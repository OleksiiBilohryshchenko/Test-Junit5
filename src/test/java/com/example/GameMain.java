package com.example;

import com.example.*;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Player playerOne = new HumanPlayer();
        Player playerTwo = new AIPlayer();

        GameEngine gameEngine = new GameEngine(playerOne, playerTwo);
        Scanner scanner = new Scanner(System.in);

        while (gameEngine.getPlayerOneScore() + gameEngine.getPlayerTwoScore() < 3) {
            System.out.println("Player One, make your move (ROCK, PAPER, SCISSORS):");
            String input = scanner.nextLine();

            try {
                Move playerMove = Move.valueOf(input.toUpperCase());
                ((HumanPlayer) playerOne).setMove(playerMove);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move! Please enter ROCK, PAPER, or SCISSORS.");
                continue;
            }

            Move aiMove = playerTwo.makeMove(); // Generate AI move
            System.out.println("Player Two (AI) chose: " + aiMove);

            Result result = gameEngine.playRound();
            System.out.println("Round Result: " + result);
            System.out.println("Scores: Player One = " + gameEngine.getPlayerOneScore() +
                    ", Player Two = " + gameEngine.getPlayerTwoScore());
        }

        System.out.println("Final Result: " + gameEngine.determineOverallWinner());
    }
}
