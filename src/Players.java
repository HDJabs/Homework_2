import cs331Helper.cs331TicTacToePlayer;
import cs331Helper.cs331TicTacToeBoard;
import cs331Helper.cs331TicTacToeController;

public class Players implements cs331TicTacToePlayer {
    
    private String letter;
    private cs331TicTacToeBoard board;
    private cs331TicTacToeController controller;

    public Players(){}

    public Players(String l){
        this.letter = l;
    }

    public Players(String l, cs331TicTacToeBoard b, cs331TicTacToeController c){
        this.letter = l;
        this.board = b;
        this.controller = c;
    }

    public String getLetter(){
        return this.letter;
    }

    @Override
    public void selectSquare(int arg1, int arg2){
        board.squareAt(arg1, arg2).markSquare(letter);
        controller.setControllerMessage("Player " + this.letter + " has finished their turn" );
        controller.finishedTurn();
    }
}
