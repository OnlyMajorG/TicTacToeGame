package at.technikum.wien.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void makeMove_WithValidCoordinates_PlacesMarkerSuccessfully() {
        // Given
        int x = 1, y = 1;
        Player currentPlayer = ticTacToe.getCurrentPlayer();
        
        // When
        boolean result = ticTacToe.makeMove(x, y);
        
        // Then
        assertTrue(result);
        assertEquals(currentPlayer.getMarker(), ticTacToe.getBoard().getCells()[x][y]);
    }

    @Test
    void makeMove_WithInvalidCoordinates_ReturnsFalse() {
        // Given
        int x = -1, y = 0;
        
        // When
        boolean result = ticTacToe.makeMove(x, y);
        
        // Then
        assertFalse(result);
    }

    @Test
    void makeMove_OnOccupiedField_ReturnsFalse() {
        // Given
        int x = 0, y = 0;
        ticTacToe.makeMove(x, y); // Place first marker
        
        // When
        boolean result = ticTacToe.makeMove(x, y); // Try to place on same position
        
        // Then
        assertFalse(result);
    }

    @Test
    void nextTurn_AfterValidMove_SwitchesCurrentPlayer() {
        // Given
        Player initialPlayer = ticTacToe.getCurrentPlayer();
        ticTacToe.makeMove(0, 0); // Valid move
        
        // When
        ticTacToe.nextTurn();
        
        // Then
        Player newPlayer = ticTacToe.getCurrentPlayer();
        assertNotEquals(initialPlayer, newPlayer);
        assertNotEquals(initialPlayer.getMarker(), newPlayer.getMarker());
    }

    @Test
    void getCurrentPlayer_AfterInvalidMove_KeepsCurrentPlayer() {
        // Given
        Player initialPlayer = ticTacToe.getCurrentPlayer();
        ticTacToe.makeMove(-1, -1); // Invalid move
        
        // When
        Player currentPlayer = ticTacToe.getCurrentPlayer();
        
        // Then
        assertEquals(initialPlayer, currentPlayer);
        assertEquals(initialPlayer.getMarker(), currentPlayer.getMarker());
    }

    @Test
    void makeMove_WithDifferentValidCoordinates_WorksCorrectly() {
        // Given & When & Then
        assertTrue(ticTacToe.makeMove(0, 0));
        assertTrue(ticTacToe.makeMove(1, 1));
        assertTrue(ticTacToe.makeMove(2, 2));
        assertTrue(ticTacToe.makeMove(0, 1));
        assertTrue(ticTacToe.makeMove(1, 0));
    }

    @Test
    void constructor_InitializesWithPlayerX_AsCurrentPlayer() {
        // When
        Player currentPlayer = ticTacToe.getCurrentPlayer();
        
        // Then
        assertEquals('X', currentPlayer.getMarker());
    }

    @Test
    void nextTurn_TwiceCalled_ReturnsTofirstPlayer() {
        // Given
        Player initialPlayer = ticTacToe.getCurrentPlayer();
        
        // When
        ticTacToe.nextTurn();
        ticTacToe.nextTurn();
        
        // Then
        Player finalPlayer = ticTacToe.getCurrentPlayer();
        assertEquals(initialPlayer, finalPlayer);
        assertEquals(initialPlayer.getMarker(), finalPlayer.getMarker());
    }

    @Test
    void hasWinner_WithEmptyBoard_ReturnsFalse() {
        // When
        boolean hasWinner = ticTacToe.hasWinner();
        
        // Then
        assertFalse(hasWinner);
    }

    @Test
    void hasWinner_WithHorizontalWin_ReturnsTrue() {
        // Given - Create horizontal win in first row
        ticTacToe.makeMove(0, 0); // X
        ticTacToe.makeMove(0, 1); // X
        ticTacToe.makeMove(0, 2); // X
        
        // When
        boolean hasWinner = ticTacToe.hasWinner();
        
        // Then
        assertTrue(hasWinner);
    }

    @Test
    void hasWinner_WithVerticalWin_ReturnsTrue() {
        // Given - Create vertical win in first column
        ticTacToe.makeMove(0, 0); // X
        ticTacToe.makeMove(1, 0); // X
        ticTacToe.makeMove(2, 0); // X
        
        // When
        boolean hasWinner = ticTacToe.hasWinner();
        
        // Then
        assertTrue(hasWinner);
    }

    @Test
    void hasWinner_WithDiagonalWin_ReturnsTrue() {
        // Given - Create diagonal win
        ticTacToe.makeMove(0, 0); // X
        ticTacToe.makeMove(1, 1); // X
        ticTacToe.makeMove(2, 2); // X
        
        // When
        boolean hasWinner = ticTacToe.hasWinner();
        
        // Then
        assertTrue(hasWinner);
    }

    @Test
    void resetGame_ClearsBoard_AndSwitchesStartPlayer() {
        // Given
        Player initialPlayer = ticTacToe.getCurrentPlayer();
        ticTacToe.makeMove(1, 1);
        
        // When
        ticTacToe.resetGame();
        
        // Then
        // Board should be empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', ticTacToe.getBoard().getCells()[i][j]);
            }
        }
        // Start player should be different
        assertNotEquals(initialPlayer, ticTacToe.getCurrentPlayer());
    }
}
