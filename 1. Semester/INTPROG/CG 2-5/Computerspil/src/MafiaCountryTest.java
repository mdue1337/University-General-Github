/**
 * @author Martin Due & Mathias Bøttger
 * @version 22/11-2025
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MafiaCountryTest {
    private Game game;
    private Country country1, country2;

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
        country2 = new MafiaCountry("Country 2");
        country1.setGame(game);
        country2.setGame(game);
    }

    @Test
    public void bonus() {
        int value = 80;
        // Bonus utilizes randomness, so we test many times to ensure expected outcome
        for (int seed = 0; seed < 1000; seed++) {
            Set<Integer> lossValues = new HashSet<>();
            Set<Integer> values = new HashSet<>();
            game.getRandom().setSeed(seed);

            int robs = 0;
            int loss = 0;

            int sum = 0;
            int iterations = 100000;

            for (int i = 0; i < iterations; i++) {
                int bonus = country2.bonus(value);

                if (bonus < 0) {
                    robs ++;
                    assertTrue(10 <= -bonus && -bonus <= 50);   // Robbed value is in the given range
                    loss -= bonus;
                    lossValues.add(-bonus);
                } else {
                    // bounds
                    assertTrue(0 <= bonus && bonus <= value);
                    values.add(bonus);
                    sum += bonus;
                }
            }

            assertTrue(robs > (iterations / 5.0 * 0.95) && robs < (iterations / 5.0 * 1.05));   // Gets robbed about 1/5 of the time
            assertTrue(loss < 31.0 * robs && loss > 29.0 * robs); // equivalent with loss/robs < 31. On average gets robbed for 30
            assertEquals(40 + 1, lossValues.size());    // The robbed value is in the given range

            // Checks that the rest is still accurate
            assertEquals(value + 1, values.size());

            double expected = iterations * 0.8 * value/2;
            assertTrue(0.99*expected<=sum && sum <= expected * 1.01);

            // if bonus has parameter 0 or 1
            assertEquals(0, country1.bonus(0));
            assertTrue(0 <= country1.bonus(1) && country1.bonus(1) <= 1);
        }
    }
}
