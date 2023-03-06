package lld.tictactoe.botplayingstrategies;

import lld.tictactoe.models.Board;
import lld.tictactoe.models.Move;
import lld.tictactoe.models.Player;

public interface BotPlayingStrategy {
    Move makeNextMove(Board board, Player player);
}