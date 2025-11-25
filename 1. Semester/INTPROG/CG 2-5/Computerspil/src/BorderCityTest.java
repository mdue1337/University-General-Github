/**
 * @author Martin Due & Mathias Bøttger
 * @version 22/11-2025
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BorderCityTest {
    private Game game;
    private Country country1, country2;
    private City cityC, cityD, cityE;

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        // Create game object
        game = new Game(0);

        // Create countries
        country1 = new Country("Country 1");
        country2 = new Country("Country 2");
        country1.setGame(game);
        country2.setGame(game);

        // Create cities
        cityC = new BorderCity("City C", 40, country1);
        cityD = new BorderCity("City D", 100, country1);
        cityE = new BorderCity("City E", 50, country2);

        // Connect cities to countries
        country1.addCity(cityC);
        country1.addCity(cityD);
        country2.addCity(cityE);

        // Create roads
        country1.addRoads(cityC, cityD, 2);
        country1.addRoads(cityC, cityE, 4);
        country2.addRoads(cityE, cityC, 4);
    }

    @Test
    public void arriveFromOtherCountry() {
        for(int seed = 0; seed < 1000; seed++) {
            Player player = new GUIPlayer(new Position(cityE, cityC, 0), 250);
            game.getRandom().setSeed(seed); // Set seed

            int bonus = country1.bonus(40); // Remember bonus
            int toll = 250 / 5; // 20% of 250
            game.getRandom().setSeed(seed); // Reset seed

            assertEquals(bonus - toll, cityC.arrive(player)); // Same bonus
            assertEquals(40 - bonus + toll, cityC.getValue());
            cityC.reset();
        }
    }

    @Test
    public void arrive() {
        for(int seed = 0; seed < 1000; seed++) {
            Player player = new GUIPlayer(new Position(cityC, cityD, 0), 250);
            game.getRandom().setSeed(seed); // Set seed

            int bonus = country1.bonus(100); // Remember bonus
            game.getRandom().setSeed(seed); // Reset seed

            assertEquals(bonus, cityD.arrive(player)); // Same bonus
            assertEquals(100 - bonus, cityD.getValue());
            cityD.reset();
        }
    }
}
