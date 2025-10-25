package LLDQuestions.MyTicTacToe;
import LLDQuestions.MyTicTacToe.Models.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please Enter Size of Board");
        Scanner scanner = new Scanner(System.in);
        Integer size = scanner.nextInt();
        Board board = new Board(size);
        TicTacToeGame game = new TicTacToeGame(size, board);
        game.startGame();
        scanner.close();    
    }
}
