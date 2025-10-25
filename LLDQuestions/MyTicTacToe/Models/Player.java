package LLDQuestions.MyTicTacToe.Models;

public class Player {
    public Piece piece;
    public int playerId;
    public Player(int playerId, Piece piece)
    {
        this.playerId = playerId;
        this.piece = piece;
    }
}
