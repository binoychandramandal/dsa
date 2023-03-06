package lld.tictactoe.controller;


import lld.tictactoe.exceptions.EmptyMovesUndoOperationException;
import lld.tictactoe.gamewinningstrategies.GameWinningStrategy;
import lld.tictactoe.models.Game;
import lld.tictactoe.models.GameStatus;
import lld.tictactoe.models.Player;

import java.util.List;

// Start a game
// Make a move
// Undo
// CheckWinner
// GetCurrentState
public class GameController {
    public Game createGame(int dimensionOfBoard,
                           List<Player> players,
                           List<GameWinningStrategy> strategies) {
        Game game = null;

        try {
            game = Game.create()
                    .setDimenston(dimensionOfBoard)
                    .addPlayers(players)
                    .addGameWinningStrategies(strategies)
                    .build();
        } catch (Exception exception) {
            System.out.println("We did something wrong");
            exception.printStackTrace();
        }

        return game;
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public boolean undo(Game game) throws EmptyMovesUndoOperationException {
        return game.undo();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void display(Game game) {
        game.getBoard().printBoard();
    }
}