/**
 * @author Martin Due & Mathias Bøttger
 * @version 11/11-2025
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private City cityA, cityB, cityC, cityD;
    private int lengthAB, lengthCD;
    private Position pos1, pos2;

    @BeforeEach
    public void setUp(){
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

        // Assign
        lengthAB = 10;
        lengthCD = 20;
        pos1 = new Position(cityA, cityB, lengthAB);
        pos2 = new Position(cityC, cityD, lengthCD);
    }

    @Test
    public void constructor(){
        assertEquals(cityA, pos1.getFrom());
        assertEquals(cityB, pos1.getTo());
        assertEquals(lengthAB, pos1.getDistance());
        assertEquals(lengthAB, pos1.getTotal());

        assertEquals(cityC, pos2.getFrom());
        assertEquals(cityD, pos2.getTo());
        assertEquals(lengthCD, pos2.getDistance());
        assertEquals(lengthCD, pos2.getTotal());
    }

    @Test
    public void move(){
        // Act
        pos1.move();
        pos2.move();

        // Assert correct decrement logic
        assertEquals(lengthAB - 1, pos1.getDistance());
        assertEquals(lengthCD - 1, pos2.getDistance());

        // Assert that it can never be less than 0, as it runs 1 time at distance 0.
        for (int i = 0; i < lengthAB; i++) {
            pos1.move();
        }
        assertEquals(lengthAB, pos1.getTotal());
        assertEquals(0, pos1.getDistance());

        // Assert boolean return, true if we can move, false if not.
        assertFalse(pos1.move());
        assertTrue(pos2.move());
    }

    @Test
    public void turnAround(){
        // Act
        pos1.move();
        pos1.turnAround();

        // Assert
        assertEquals(pos1.getFrom(), cityB);
        assertEquals(pos1.getTo(), cityA);
        assertEquals(1, pos1.getDistance());

        pos1.turnAround();
        assertEquals(pos1.getFrom(), cityA);
        assertEquals(pos1.getTo(), cityB);
        assertEquals(9, pos1.getDistance());

        pos2.turnAround();
        assertEquals(pos2.getFrom(), cityD);
        assertEquals(pos2.getTo(), cityC);
        assertEquals(0, pos2.getDistance());

        // Act
        pos2.turnAround();
        assertEquals(pos2.getFrom(), cityC);
        assertEquals(pos2.getTo(), cityD);
        assertEquals(20, pos2.getDistance());
    }

    @Test
    public void hasArrived(){
        // Assert that we have not arrived yet, thus a return of false
        assertFalse(pos1.hasArrived());
        assertFalse(pos2.hasArrived());

        // Act, move until distance is 0:
        for (int i = 0; i < lengthAB; i++) {
            pos1.move();
        }
        for (int i = 0; i < lengthCD; i++) {
            pos2.move();
        }

        // Assert
        assertTrue(pos1.hasArrived());
        assertTrue(pos2.hasArrived());
    }

    @Test
    public void testToString(){
        // Assert
        assertEquals("City A (80) -> City B (60) : 10/10", pos1.toString());
        assertEquals("City C (40) -> City D (100) : 20/20", pos2.toString());

        // Act
        pos1.move();
        pos2.move();

        // Assert
        assertEquals("City A (80) -> City B (60) : 9/10", pos1.toString());
        assertEquals("City C (40) -> City D (100) : 19/20", pos2.toString());
    }
}
