package LLDQuestions.MyTicTacToe;


import LLDQuestions.MyTicTacToe.Models.*;
import java.util.*;

public class TicTacToeGame {
    Board board;
    int size;
    Deque<Player> players;

    public TicTacToeGame(int size, Board board)
    {
        this.size = size;
        this.board = board;
        this.players = new ArrayDeque<Player>();
    }
    public void startGame()
    {
        Scanner scanner = new Scanner(System.in);
        boolean isWinner = false;
        Piece pieceX = new PlayingPieceX();
        Piece pieceO = new PlayingPieceO();
        Player player1 = new Player(1, pieceX);
        Player player2 = new Player(2, pieceO);
        players.add(player1);
        players.add(player2);
        int count = 0;
        while(!isWinner || count <size*size)
        {
            Player curr = players.getFirst();
            players.removeFirst();
            board.printBoard();
            System.out.println("Player "+ curr.playerId + " enter row and column");
            
            String input = scanner.nextLine();
            String[] values = input.split(",");
            int row = Integer.parseInt(values[0]), column=Integer.parseInt(values[1]);
            boolean pieceAdded = board.addPiece(row, column, curr.piece);
            if(!pieceAdded)
            {
                System.out.println("Invalid input, please try again!");
                players.addFirst(curr);
                continue;
            }
            players.addLast(curr);
            count += 1;
            isWinner = isThereWinner(row, column, curr);
            if(isWinner)
            {
                System.out.println("Wohoo!, Player "+ curr.playerId + " Winner");
                scanner.close();
                return;
            }
        }
        
        scanner.close();
        System.out.println("Game Tied");
    }
    public boolean isThereWinner(int i, int j, Player curr)
    {
        boolean isWinner = true;
        for(int k=0;k<size;k++)
        {
            if(board.board[i][k] == null || board.board[i][k].pieceType != curr.piece.pieceType)
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int k=0;k<size;k++)
        {
            if(board.board[k][j] ==null || board.board[k][j].pieceType !=curr.piece.pieceType)
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int k=0;k<size;k++)
        {
            if(board.board[k][k] ==null || board.board[k][k].pieceType != curr.piece.pieceType)
            {
                isWinner = false;
                break;
            }
        }
        if(isWinner)
            return true;
        isWinner = true;
        for(int k=0;k<size;k++)
        {
            if(board.board[size-1-k][k] ==null || board.board[size-1-k][k].pieceType != curr.piece.pieceType)
            {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }
}
