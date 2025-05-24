package at.technikum.wien.tictactoe;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean place(int x, int y, char marker) {
        if (isValidCoordinate(x, y) && isCellEmpty(x, y)) {
            cells[x][y] = marker;
            return true;
        }
        return false;
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }

    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = ' ';
    }

    public void print(Player player) {
        System.out.println("Spieler " + player.getMarker() + " ist am Zug:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + cells[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    }
}

