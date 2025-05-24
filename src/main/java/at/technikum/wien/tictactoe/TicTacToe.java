package at.technikum.wien.tictactoe;

public class TicTacToe {
    private final Player currentPlayer;
    private final Board board;

    public TicTacToe() {
        currentPlayer = new Player('X');
        board = new Board();
    }

    public boolean makeMove(int x, int y) {
        return board.place(x, y, currentPlayer.getMarker());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
}
