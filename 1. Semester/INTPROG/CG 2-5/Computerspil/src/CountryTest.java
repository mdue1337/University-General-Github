/**
 * @author Martin Due & Mathias Bøttger
 * @version 16/11-2025
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CountryTest {
    private Game game1, game2;
    private Country country1, country2;
    private int valueA, valueB, valueE;
    private City cityA, cityB, cityE;

    @BeforeEach
    public void setUp() {
        // Create game object
        game1 = new Game(0);
        game2 = new Game(1);

        // Create country
        country1 = new Country("Country 1");
        country1.setGame(game1);
        country2 = new Country("Country 2");
        country2.setGame(game2);

        // Set fields
        valueA = 80;
        valueB = 60;
        valueE = 20;

        // Create cities
        cityA = new City("City A", valueA, country1);
        cityB = new City("City B", valueB, country1);
        cityE = new City("City E", valueE, country2);

        country1.addCity(cityA);
        country1.addCity(cityB);
        country2.addCity(cityE);
    }

    @Test
    public void constructor(){
        assertEquals("Country 1", country1.getName());
        assertEquals("Country 2", country2.getName());
        assertFalse(country1.getCities().isEmpty()); // Fordi vi har fyldt lande på, ellers burde konstruktøren være en tom liste
        assertFalse(country2.getCities().isEmpty());

        // Tjek om game er opsat korrekt.
        assertEquals(game1, country1.getGame());
        assertEquals(game2, country2.getGame());
        assertEquals(2, country1.getCities().size()); // cityA + cityB
        assertEquals(1, country2.getCities().size()); // cityE
    }


    @Test
    public void getCities() {
        // Assertions
        assertEquals(2, country1.getCities().size());
        assertEquals(1, country2.getCities().size());
    }

    @Test
    public void addCity(){
        assertEquals(2, country1.getCities().size());
        City cityX = new City("City X", 20, country1);
        country1.addCity(cityX);
        assertEquals(3, country1.getCities().size());
        assertEquals(cityX, country1.getCity("City X"));
    }

    @Test
    public void getCity(){
        assertNull(country1.getCity("ABC")); // Does not exist
        assertEquals(cityA, country1.getCity("City A"));
        assertEquals(cityE, country2.getCity("City E"));
    }

    @Test
    public void reset() {
        cityA.arrive(); cityA.arrive(); cityA.arrive();
        cityE.arrive(); cityE.arrive(); cityE.arrive();

        int valueE = cityE.getValue(); // Remember value of cityE
        country1.reset(); // Reset cityA

        assertEquals(valueA, cityA.getValue()); // cityA is reset
        assertEquals(valueE, cityE.getValue()); // cityE is unchanged
    }

    @Test
    public void bonus() {
        // Bonus utilizes randomness, so we test many times to ensure expected outcome
        for (int seed = 0; seed < 100; seed++) {
            Set<Integer> values = new HashSet<>();

            game1.getRandom().setSeed(seed);
            int sum = 0;
            int iterations = 100000;

            for (int i = 0; i < iterations; i++) {
                int bonus = country1.bonus(100);
                // bounds
                assertTrue(0 <= bonus && bonus <= 100);
                values.add(bonus);
                sum += bonus;
            }

            assertEquals(100 + 1, values.size());
            // average
            int expected = iterations * 100/2;
            assertTrue(0.99*expected<=sum && sum <= expected * 1.01);

            // if bonus has parameter 0 or 1
            assertEquals(0, country1.bonus(0));
            assertTrue(0 <= country1.bonus(1) && country1.bonus(1) <= 1);
        }
    }

    @Test
    public void getRoads() {
        country1.addRoads(cityA, cityB, 10);
        assertTrue(country1.getRoads(cityA).contains(new Road(cityA, cityB, 10)));
        assertFalse(country1.getRoads(cityE).contains(new Road(cityA, cityB, 10)));
    }

    @Test
    public void addRoads() {
        // No roads yet
        assertEquals(0, country1.getRoads(cityA).size());
        // Length must be greater than 0
        country1.addRoads(cityA, cityB, 0);
        assertEquals(0, country1.getRoads(cityA).size());

        // A city cant have a road to itself
        country1.addRoads(cityA, cityA, 10);
        assertEquals(0, country1.getRoads(cityA).size());

        // number of roads from cityA should increase
        country1.addRoads(cityA, cityB, 10);
        assertEquals(1, country1.getRoads(cityA).size());

        // Already exists. Road should not increase.
        country1.addRoads(cityA, cityB, 10);
        assertEquals(1, country1.getRoads(cityA).size());

        // Different road, because of length.
        country1.addRoads(cityA, cityB, 20);
        assertEquals(2, country1.getRoads(cityA).size());

        // As should number of roads from cityB
        assertEquals(2, country1.getRoads(cityB).size());

        // Different country's
        country1.addRoads(cityA, cityE, 10);
        assertEquals(3, country1.getRoads(cityA).size());
        assertEquals(0, country2.getRoads(cityB).size());
    }

    @Test
    public void position(){
        assertEquals(new Position(cityA, cityA, 0), country1.position(cityA));
        assertNotEquals(new Position(cityA, cityB, 0), country1.position(cityA));
    }

    @Test
    public void readyToTravel(){
        country1.addRoads(cityA, cityB, 15);

        // Same city a position is returned
        assertEquals(country1.position(cityA), country1.readyToTravel(cityA, cityA));

        // Not same country, return position of from
        assertEquals(country1.position(cityA), country1.readyToTravel(cityA, cityE));

        // Find roads
        Position pos = country1.readyToTravel(cityA, cityB);

        // Assertions: should return a Position matching the road
        assertEquals(cityA, pos.getFrom());
        assertEquals(cityB, pos.getTo());
        assertEquals(15, pos.getDistance());

        // Otherwise return from
        assertEquals(country1.position(cityA), country1.readyToTravel(cityA, null));
    }

    @Test
    public void testToString(){
        assertEquals("Country 1", country1.toString());
        assertEquals("Country 2", country2.toString());
    }
}
