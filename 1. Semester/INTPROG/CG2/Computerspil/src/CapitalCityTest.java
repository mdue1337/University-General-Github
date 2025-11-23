/**
 * @author Martin Due & Mathias Bøttger
 * @version 22/11-2025
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapitalCityTest {
    private Game game;
    private Country country1, country2;
    private City cityA, cityB, cityC, cityD, cityE, cityF, cityG;

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
        cityA = new City("City A", 80, country1);
        cityB = new City("City B", 60, country1);
        cityC = new CapitalCity("City C", 40, country1);
        cityD = new CapitalCity("City D", 100, country1);

        cityE = new BorderCity("City E", 50, country2);
        cityF = new BorderCity("City F", 90, country2);
        cityG = new City("City G", 70, country2);

        // Connect cities to countries
        country1.addCity(cityA);
        country1.addCity(cityB);
        country1.addCity(cityC);
        country1.addCity(cityD);

        country2.addCity(cityE);
        country2.addCity(cityF);
        country2.addCity(cityG);

        // Create roads
        country1.addRoads(cityA, cityB, 4);
        country1.addRoads(cityA, cityC, 3);
        country1.addRoads(cityA, cityD, 5);
        country1.addRoads(cityB, cityD, 2);
        country1.addRoads(cityC, cityD, 2);
        country1.addRoads(cityC, cityE, 4);
        country1.addRoads(cityD, cityF, 3);
        country2.addRoads(cityE, cityC, 4);
        country2.addRoads(cityE, cityF, 2);
        country2.addRoads(cityE, cityG, 5);
        country2.addRoads(cityF, cityD, 3);
        country2.addRoads(cityF, cityG, 6);
    }

    @Test
    public void arriveFromOtherCountry() {
        for(int seed = 0; seed < 1000; seed++) {
            Player player = new GUIPlayer(new Position(cityE, cityC, 0), 250);
            game.getRandom().setSeed(seed); // Set seed

            int bonus = country1.bonus(40); // Remember bonus
            int toll = 250 / 5; // 20% of 250
            Random random = game.getRandom();
            int expenses = random.nextInt(0, player.getMoney() + 1);
            game.getRandom().setSeed(seed); // Reset seed

            assertEquals(bonus - toll - expenses, cityC.arrive(player)); // Same bonus
            assertEquals(40 - bonus + toll + expenses , cityC.getValue());

            cityC.reset();
        }
    }

    @Test
    public void arrive() {
        for(int seed = 0; seed < 1000; seed++) {
            Player player = new GUIPlayer(new Position(cityB, cityD, 0), 250);
            game.getRandom().setSeed(seed); // Set seed

            int bonus = country1.bonus(100); // Remember bonus
            Random random = game.getRandom();
            int expenses = random.nextInt(0, player.getMoney() + 1);
            game.getRandom().setSeed(seed); // Reset seed

            assertEquals(bonus - expenses, cityD.arrive(player)); // Same bonus
            assertEquals(100 - bonus + expenses, cityD.getValue());
            cityD.reset();
        }
    }
}
