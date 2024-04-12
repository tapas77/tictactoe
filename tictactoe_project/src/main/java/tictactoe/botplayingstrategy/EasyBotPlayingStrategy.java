package tictactoe.botplayingstrategy;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell makeMove(Board board){
        for(List<Cell> rows : board.getBoard()){
            for(Cell cell : rows){
                if(CellState.EMPTY.equals(cell.getCellState())){
                    return cell;
                }
            }
        }
        return null;
    }
}
