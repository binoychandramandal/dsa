package lld.tictactoe;

import lld.tictactoe.controller.GameController;
import lld.tictactoe.gamewinningstrategies.GameWinningStrategy;
import lld.tictactoe.gamewinningstrategies.OrderOneGameWinningStrategy;
import lld.tictactoe.models.*;

import java.util.Arrays;

public class GameSimulator {

    private static Symbol symbol;

    public static void main(String[] args) {
        int dimension = 3;
        Player p1 = new HumanPlayer(new Symbol('X'));
        Player p2 = new HumanPlayer(new Symbol('Y'));
        //Player p2 = new Bot(new Symbol('O'), BotDifficultyLevel.EASY);
        GameWinningStrategy strategy = new OrderOneGameWinningStrategy();
        GameController gameController = new GameController();

        Game game = gameController.createGame(dimension, Arrays.asList(p1, p2), Arrays.asList(strategy));

        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("Please Make the Next Move. This is current Status");
            gameController.display(game);
            gameController.makeMove(game);
        }

        if (gameController.getGameStatus(game).equals(GameStatus.ENDED)) {
            System.out.println("WINNER WINNER CHICKEN DINNER");
            gameController.display(game);
        }

        if (gameController.getGameStatus(game).equals(GameStatus.DRAW)) {
            System.out.println("UH OH. Try AGain. No one won");
            gameController.display(game);
        }
    }
    }