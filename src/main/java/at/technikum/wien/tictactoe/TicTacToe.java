package at.technikum.wien.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public boolean makeMove(int x, int y) {
        return board.place(x, y, currentPlayer.getMarker());
    }

    public void nextTurn() {
        switchCurrentPlayer();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasWinner() {
        char[][] cells = board.getCells();

        // Zeilen und Spalten prüfen
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != ' ' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) return true;
            if (cells[0][i] != ' ' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) return true;
        }

        // Diagonalen prüfen
        if (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) return true;
        if (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) return true;

        return false;
    }

    public static boolean askForRestart() {
        System.out.println("Möchten Sie ein neues Spiel starten? (Ja/Nein)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        
        if (input.equals("ja") || input.equals("j") || input.equals("yes") || input.equals("y")) {
            return true;
        } else {
            System.out.println("Spiel beendet.");
            return false;
        }
    }
}
