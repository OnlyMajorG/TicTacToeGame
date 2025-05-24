package at.technikum.wien.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Willkommen bei Tic-Tac-Toe!");

        boolean keepPlaying = true;
        while (keepPlaying) {
            game.getBoard().print(game.getCurrentPlayer());

            try {
                System.out.print("row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("column (0-2): ");
                int col = scanner.nextInt();
                scanner.nextLine();

                boolean moveMade = game.makeMove(row, col);

                if (!moveMade) {
                    System.out.println("Ungültiger Zug. Bitte erneut versuchen.");
                }
            } catch (Exception e) {
                System.out.println("Fehlerhafte Eingabe!");
                scanner.nextLine();
            }

            // Beispiel für späteren Spielabbruch (aktuell bleibt immer true)
            // keepPlaying = false;
        }

        scanner.close();
    }
}
