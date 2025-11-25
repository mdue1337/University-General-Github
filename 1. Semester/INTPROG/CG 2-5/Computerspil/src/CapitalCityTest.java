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
    private City cityB, cityD, cityF;

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
        cityB = new City("City B", 60, country1);
        cityD = new CapitalCity("City D", 100, country1);
        cityF = new City("City F", 90, country2);

        // Connect cities to countries
        country1.addCity(cityB);
        country1.addCity(cityD);

        country2.addCity(cityF);

        // Create roads
        country1.addRoads(cityB, cityD, 2);
        country1.addRoads(cityD, cityF, 3);
        country2.addRoads(cityF, cityD, 3);
    }

    @Test
    public void arriveFromOtherCountry() {
        for(int seed = 0; seed < 1000; seed++) {
            Player player = new GUIPlayer(new Position(cityF, cityD, 0), 250);
            Random random = game.getRandom();
            random.setSeed(seed); // Set seed

            int bonus = country1.bonus(cityD.getValue()); // Remember bonus
            int toll = 250 / 5; // Toll is 20%
            int expenses = random.nextInt(player.getMoney() + 1 + bonus - toll);
            random.setSeed(seed); // Reset seed

            assertEquals(bonus - toll - expenses, cityD.arrive(player)); // Same bonus
            assertEquals(cityD.getInitialValue() - bonus + expenses + toll, cityD.getValue());

            cityD.reset();
        }
    }

    @Test
    public void arrive() {
        for(int seed = 0; seed < 1000; seed++) {
            Player player = new GUIPlayer(new Position(cityB, cityD, 0), 250);
            Random random = game.getRandom();
            random.setSeed(seed); // Set seed

            int bonus = country1.bonus(cityD.getValue()); // Remember bonus

            int expenses = random.nextInt(player.getMoney() + 1 + bonus);
            game.getRandom().setSeed(seed); // Reset seed

            assertEquals(bonus - expenses, cityD.arrive(player)); // Same bonus
            assertEquals(cityD.getInitialValue() - bonus + expenses, cityD.getValue());
            cityD.reset();

            cityD.changeValue(-cityD.getInitialValue());
            assertEquals(0, cityD.arrive());
            cityD.reset();
        }
    }
}
