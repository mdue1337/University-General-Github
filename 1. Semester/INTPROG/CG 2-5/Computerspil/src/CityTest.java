/**
 * @author Martin Due & Mathias Bøttger
 * @version 11/11-2025
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {
    private Game game;
    private Country country1;
    private int valueA, valueB;
    private String nameA, nameB;
    private City cityA, cityB;


    @BeforeEach
    public void setUp() {
        // Create game object
        game = new Game(0);

        // Create country
        country1 = new Country("Country 1");
        country1.setGame(game);

        // Set fields
        nameA = "City A";
        nameB = "City B";
        valueA = 80;
        valueB = 60;

        // Create cities
        cityA = new City("City A", valueA, country1);
        cityB = new City("City B", valueB, country1);

        // Connect cities to countries
        country1.addCity(cityA);
        country1.addCity(cityB);
    }

    @Test
    public void constructor(){
        // Assert cityA
        assertEquals(nameA, cityA.getName());
        assertEquals(valueA, cityA.getValue());
        assertEquals(valueA, cityA.getInitialValue());
        assertEquals(country1, cityA.getCountry());

        // Assert cityB
        assertEquals(nameB, cityB.getName());
        assertEquals(valueB, cityB.getValue());
        assertEquals(valueB, cityB.getInitialValue());
        assertEquals(country1, cityB.getCountry());
    }

    @Test
    public void arrive(){
        for(int seed = 0; seed < 1000; seed++) { // Try different seeds
            game.getRandom().setSeed(seed); // Set seed
            int bonus = country1.bonus(valueA); // Remember bonus
            game.getRandom().setSeed(seed); // Reset seed

            assertEquals(bonus, cityA.arrive());
            assertEquals(valueA - bonus, cityA.getValue());
            cityA.reset();

            cityA.changeValue(-valueA);
            assertEquals(0, cityA.arrive());
            cityA.reset();
        }
    }

    @Test
    public void reset(){
        // Act
        cityA.arrive(); cityA.arrive(); cityA.arrive();
        cityB.arrive(); cityB.arrive(); cityB.arrive();

        // Assert not initialValue
        assertNotEquals(valueA, cityA.getValue());
        assertNotEquals(valueB, cityB.getValue());

        // Act
        cityA.reset(); cityB.reset();

        // Assert
        assertEquals(valueA, cityA.getValue());
        assertEquals(valueB, cityB.getValue());
    }

    @Test
    public void changeValue(){
        // Act
        cityA.changeValue(10);
        cityB.changeValue(20);

        // Assert
        assertEquals(valueA + 10, cityA.getValue());
        assertEquals(valueB + 20, cityB.getValue());

        // Act
        cityA.changeValue(-20);
        cityB.changeValue(-30);

        // Assert
        assertEquals(valueA - 10, cityA.getValue());
        assertEquals(valueB - 10, cityB.getValue());
    }

    @Test
    public void testToString(){
        assertEquals("City A (80)", cityA.toString());
        assertEquals("City B (60)", cityB.toString());
    }
}
