package LLDQuestions.MyTicTacToe.Models;

public class Board {
    public int size;
    public Piece board[][];
    public Board(int size)
    {
        this.size = size;
        this.board = new Piece[size][size];
    }
    public boolean addPiece(int row, int column, Piece piece)
    {
        if(board[row][column] == null)
        {
            board[row][column] = piece;
            return true;
        }
        return false;
    }
    public void printBoard()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j] == null)
                {
                    System.out.print("   ");    
                }
                else
                {
                    System.out.print(board[i][j].pieceType + "  ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
