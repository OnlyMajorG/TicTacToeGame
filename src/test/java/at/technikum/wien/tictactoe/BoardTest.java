package at.technikum.wien.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void place_OnEmptyField_PlacesMarkerSuccessfully() {
        // Given
        int x = 1, y = 1;
        char marker = 'X';
        
        // When
        boolean result = board.place(x, y, marker);
        
        // Then
        assertTrue(result);
        assertEquals(marker, board.getCells()[x][y]);
    }

    @Test
    void place_OnOccupiedField_ReturnsFalse() {
        // Given
        int x = 0, y = 0;
        char firstMarker = 'X';
        char secondMarker = 'O';
        board.place(x, y, firstMarker);
        
        // When
        boolean result = board.place(x, y, secondMarker);
        
        // Then
        assertFalse(result);
        assertEquals(firstMarker, board.getCells()[x][y]);
    }

    @Test
    void place_WithInvalidCoordinatesNegative_ReturnsFalse() {
        // Given
        int x = -1, y = 0;
        char marker = 'X';
        
        // When
        boolean result = board.place(x, y, marker);
        
        // Then
        assertFalse(result);
    }

    @Test
    void place_WithInvalidCoordinatesOutOfBounds_ReturnsFalse() {
        // Given
        int x = 3, y = 2;
        char marker = 'X';
        
        // When
        boolean result = board.place(x, y, marker);
        
        // Then
        assertFalse(result);
    }

    @Test
    void place_WithValidCoordinatesCorners_PlacesMarkerSuccessfully() {
        // Given
        char marker = 'O';
        
        // When & Then
        assertTrue(board.place(0, 0, marker));
        assertTrue(board.place(0, 2, marker));
        assertTrue(board.place(2, 0, marker));
        assertTrue(board.place(2, 2, marker));
        
        assertEquals(marker, board.getCells()[0][0]);
        assertEquals(marker, board.getCells()[0][2]);
        assertEquals(marker, board.getCells()[2][0]);
        assertEquals(marker, board.getCells()[2][2]);
    }

    @Test
    void place_WithValidCoordinatesAllPositions_PlacesMarkersSuccessfully() {
        // Given
        char marker = 'X';
        
        // When & Then
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.place(i, j, marker));
                assertEquals(marker, board.getCells()[i][j]);
            }
        }
    }

    @Test
    void clear_AfterPlacingMarkers_EmptiesAllFields() {
        // Given
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');
        
        // When
        board.clear();
        
        // Then
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCells()[i][j]);
            }
        }
    }

    @Test
    void isFull_WithEmptyBoard_ReturnsFalse() {
        // When
        boolean result = board.isFull();
        
        // Then
        assertFalse(result);
    }

    @Test
    void isFull_WithFullBoard_ReturnsTrue() {
        // Given
        char marker = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, marker);
            }
        }
        
        // When
        boolean result = board.isFull();
        
        // Then
        assertTrue(result);
    }

    @Test
    void isFull_WithPartiallyFilledBoard_ReturnsFalse() {
        // Given
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        
        // When
        boolean result = board.isFull();
        
        // Then
        assertFalse(result);
    }
}
