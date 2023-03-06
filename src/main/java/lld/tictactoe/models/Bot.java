package lld.tictactoe.models;

import lld.tictactoe.botplayingstrategies.BotPlayingStrategy;
import lld.tictactoe.factories.botplayingstrategyfactory.BotPlayingStrategyFactory;

public class Bot extends Player {
    private BotPlayingStrategy botPlayingStrategy;
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(PlayerType.BOT, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = new BotPlayingStrategyFactory().createBotPlayingStrategyForDifficultyLevel(
                botDifficultyLevel
        );
    }

    @Override
    public Move makeMove(Board board) {
        return this.botPlayingStrategy.makeNextMove(board, this);
    }
}