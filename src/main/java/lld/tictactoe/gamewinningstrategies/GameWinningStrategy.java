package lld.tictactoe.gamewinningstrategies;


import lld.tictactoe.models.Board;
import lld.tictactoe.models.Cell;
import lld.tictactoe.models.Player;

public interface GameWinningStrategy {

    boolean checkIfWon(Board board, Player player, Cell moveCell);
}