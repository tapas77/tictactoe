package tictactoe.models;

import java.util.Scanner;
public class Player {
    private char symbol;
    private String name;
    private PlayerType playerType;
    private int id;
    private Scanner scanner;
    public Player(char symbol, String name, PlayerType playerType, int id) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
        this.id = id;
        scanner= new Scanner(System.in);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cell makeMove(Board board) {
        System.out.println(this.name+"!! It's your turn to make a move, enter row and column");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        while(validateMove(row,col,board)==false){
            System.out.println(this.name+"!! invalid move, Please try again");
            row = scanner.nextInt();
            col = scanner.nextInt();
        }
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }

    private boolean validateMove(int row, int col, Board board) {
        if(row>= board.getDimension()){
            return false;
        }
        if(col>=board.getDimension()){
            return false;
        }
        if(CellState.FILLED.equals(board.getBoard().get(row).get(col).getCellState())){
            return false;
        }
        return  true;
    }
}
