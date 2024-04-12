package tictactoe.winningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {
    Map<Character,Integer> leftDiagonal = new HashMap<>();
    Map<Character,Integer> rightDiagonal = new HashMap<>();


    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getSymbol();
        if(row==col){
            if(!leftDiagonal.containsKey((symbol))){
                leftDiagonal.put(symbol,0);
            }
            leftDiagonal.put(symbol,leftDiagonal.get(symbol)+1);
            if(leftDiagonal.get(symbol)==board.getBoard().size()){
                System.out.println("COngrats!!! winning via diagonal 00-22 ");
                return true;
            }
        }
//        replace board.getDimension()-1 with board.getBoard().size()-1
        if(row+col==board.getDimension()-1){
            if(!rightDiagonal.containsKey((symbol))){
                rightDiagonal.put(symbol,0);
            }
            rightDiagonal.put(symbol,rightDiagonal.get(symbol)+1);
            if(rightDiagonal.get(symbol)==board.getBoard().size()){
                System.out.println("COngrats!!! winning via diagonal 02-20 ");
                return true;
            }
        }
        return false;
    }
    @Override
    public void undo(Board board, Move lastMove){
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        char symbol = lastMove.getSymbol();
        if(row==col){
            leftDiagonal.put(symbol,leftDiagonal.get(symbol)-1);
        }
        if(row+col==board.getDimension()-1){
            rightDiagonal.put(symbol,rightDiagonal.get(symbol)-1);
        }
    }
}
