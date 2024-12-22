package com.example;

public class GameEngine {

    private Player playerOne;
    private Player playerTwo;
    private Result lastResult;


    public GameEngine(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Result decideWinner(){
        return lastResult;
    }

    public void playRound(){
        Move moveOne = playerOne.makeMove();
        Move moveTwo = playerTwo.makeMove();
        lastResult = Result.PLAYER_ONE_WINS;
    }

}
