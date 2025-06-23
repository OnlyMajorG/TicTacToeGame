package at.technikum.wien.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        
        while (playAgain) {
            TicTacToe game = new TicTacToe();
            
            // Spiel-Schleife
            while (true) {
                System.out.println();
                System.out.println("Current Player: " + game.getCurrentPlayer().getMarker());
                game.getBoard().print();

                try {
                    System.out.print("row (0–2): ");
                    int row = scanner.nextInt();
                    System.out.print("column (0–2): ");
                    int col = scanner.nextInt();
                    scanner.nextLine();

                    boolean moveMade = game.makeMove(row, col);

                    if (!moveMade) {
                        System.out.println("Invalid move. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter two numbers.");
                    scanner.nextLine();
                }

                if (game.hasWinner()) {
                    game.getBoard().print();
                    char winnerSymbol = game.getCurrentPlayer().getMarker();
                    System.out.println("Spieler " + winnerSymbol + " hat gewonnen!");
                    playAgain = TicTacToe.askForRestart();
                    break;
                } else if (game.getBoard().isFull()) {
                    System.out.println("Unentschieden! Das Spielfeld ist voll.");
                    playAgain = TicTacToe.askForRestart();
                    break;
                }

                game.nextTurn();
            }
        }
        
        scanner.close();
    }
}

