package at.technikum.wien.tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void constructor_WithValidMarkerX_CreatesPlayerWithMarkerX() {
        // Given
        char expectedMarker = 'X';
        
        // When
        Player player = new Player(expectedMarker);
        
        // Then
        assertEquals(expectedMarker, player.getMarker());
    }

    @Test
    void constructor_WithValidMarkerO_CreatesPlayerWithMarkerO() {
        // Given
        char expectedMarker = 'O';
        
        // When
        Player player = new Player(expectedMarker);
        
        // Then
        assertEquals(expectedMarker, player.getMarker());
    }

    @Test
    void getMarker_AfterConstruction_ReturnsCorrectMarker() {
        // Given
        char expectedMarker = 'A';
        Player player = new Player(expectedMarker);
        
        // When
        char actualMarker = player.getMarker();
        
        // Then
        assertEquals(expectedMarker, actualMarker);
    }

    @Test
    void constructor_WithDifferentMarkers_CreatesDistinctPlayers() {
        // Given
        char markerX = 'X';
        char markerO = 'O';
        
        // When
        Player playerX = new Player(markerX);
        Player playerO = new Player(markerO);
        
        // Then
        assertEquals(markerX, playerX.getMarker());
        assertEquals(markerO, playerO.getMarker());
        assertNotEquals(playerX.getMarker(), playerO.getMarker());
    }
}
