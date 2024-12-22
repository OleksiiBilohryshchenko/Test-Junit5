package com.example;

public class GameEngine {

    private Player playerOne;
    private Player playerTwo;
    private Result lastResult;

    private Move lastMove;

    public GameEngine() {

    }

    public GameEngine(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void acceptMove (Move move) {
        this.lastMove = move;
    }

    public Move getLastMove () {
        return lastMove;
    }

    public Result decideWinner(){
        return Result.PLAYER_ONE_WINS;
    }

    public void playRound(){
        Move moveOne = playerOne.makeMove();
        Move moveTwo = playerTwo.makeMove();
        lastResult = Result.PLAYER_ONE_WINS;
    }

}
