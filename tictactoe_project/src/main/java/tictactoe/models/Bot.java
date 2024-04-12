package tictactoe.models;

import tictactoe.botplayingstrategy.BotPlayingStrategy;
import tictactoe.botplayingstrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(char symbol, String name, PlayerType playerType, int id, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, playerType, id);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public Cell makeMove(Board board){
        System.out.println("Get ready for the GPT's move ");
        Cell cell = botPlayingStrategy.makeMove(board);
        cell.setCellState(CellState.FILLED);;
        cell.setPlayer(this);
        return cell;
    }
}
