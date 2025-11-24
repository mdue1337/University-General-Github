/**
 * @author Martin Due & Mathias Bøttger
 * @version 11/11-2025
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoadTest {
    private City cityA, cityB, cityC, cityD;
    private Road road1, road2;
    private int lengthAB, lengthCD;

    @BeforeEach
    public void setUp() {
        // Create game object
        Game game = new Game(0);

        // Create country
        Country country1 = new Country("Country 1");
        country1.setGame(game);

        // Create cities
        cityA = new City("City A", 80, country1);
        cityB = new City("City B", 60, country1);
        cityC = new City("City C", 40, country1);
        cityD = new City("City D", 100, country1);

        // Assign & Act
        lengthAB = 4;
        lengthCD = 10;
        road1 = new Road(cityA, cityB, lengthAB);
        road2 = new Road(cityC, cityD, lengthCD);
    }

    @Test
    public void constructor(){
        // Assert
        assertEquals(cityA, road1.getFrom());
        assertEquals(cityB, road1.getTo());
        assertEquals(lengthAB, road1.getLength());

        // Assert
        assertEquals(cityC, road2.getFrom());
        assertEquals(cityD, road2.getTo());
        assertEquals(lengthCD, road2.getLength());
    }

    @Test
    public void testToString(){
        // Assert
        assertEquals("City A (80) -> City B (60) : 4", road1.toString());
        assertEquals("City C (40) -> City D (100) : 10", road2.toString());
    }
}