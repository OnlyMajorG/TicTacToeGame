package at.technikum.wien.tictactoe;

public class Board {
    private final char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public char[][] getCells() {
        return cells;
    }

    public boolean place(int x, int y, char marker) {
        if (isValidCoordinate(x, y) && isCellEmpty(x, y)) {
            cells[x][y] = marker;
            return true;
        }
        return false;
    }

    private boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }

    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = ' ';
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + cells[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}
