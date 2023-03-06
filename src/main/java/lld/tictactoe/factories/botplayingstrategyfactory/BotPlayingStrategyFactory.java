package lld.tictactoe.factories.botplayingstrategyfactory;

import lld.tictactoe.botplayingstrategies.BotPlayingStrategy;
import lld.tictactoe.botplayingstrategies.RandomBotPlayingStrategy;
import lld.tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy createBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {

//        BotPlayingStrategy strategy = null;
//
//        switch (difficultyLevel) {
//            case EASY ->
//        }

//        return switch (difficultyLevel) {
//            case EASY, MEDIUM, HARD -> new RandomBotPlayingStrategy();
//        };

        if(difficultyLevel.equals(BotDifficultyLevel.EASY) || difficultyLevel.equals(BotDifficultyLevel.MEDIUM) || difficultyLevel.equals(BotDifficultyLevel.HARD)){
            return new RandomBotPlayingStrategy();
        }
        return null;
    }
}