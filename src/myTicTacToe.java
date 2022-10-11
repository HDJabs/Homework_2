import cs331Helper.cs331TicTacToeBoard;
import cs331Helper.cs331TicTacToeController;
import cs331Helper.cs331TicTacToeGame;
import cs331Helper.cs331TicTacToePlayer;
import cs331Helper.cs331TicTacToeSquare;
import javafx.scene.paint.Color;

public class myTicTacToe implements cs331TicTacToeGame{
    
    private cs331TicTacToeBoard board;
    private cs331TicTacToeController controller;

    private Players X;
    private Players O;

    public myTicTacToe(){
        board = new cs331TicTacToeBoard();
        controller = new cs331TicTacToeController();
        controller.setControllerMessage("Select a square to start playing");

        X = new Players("X", board, controller);
        O = new Players("O", board, controller);

        controller.addPlayer(X);
        controller.addPlayer(O);

        //controller.finishedTurn();
        
    }

    @Override
    public void invalidSquareChosen(int arg1, int arg2){
        System.out.println(arg1 + " " + arg2);
        System.out.println("Invalid Square Chosen.");
        controller.setControllerMessage("Square chosen has already been taken. Try again.");
        board.squareAt(arg1, arg2).flashColor(Color.RED);
    }

    @Override
    public void playerWins(){
        System.out.println("Player Wins!");
        controller.setControllerMessage("Player " + ((Players)controller.getWinningPlayer()).getLetter() + " wins!");
    }

    @Override
    public void restartGame(){
        System.out.println("The game was restarted.");
        board.clearHighlights();
        board.clearSymbols();
        controller.playAgain();
    }

    @Override
    public void noWinner(){
        System.out.println("There is no winner.");
    }
}
