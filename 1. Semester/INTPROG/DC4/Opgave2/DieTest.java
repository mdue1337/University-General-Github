import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @author Martin Due & Mathis Bøttger
 * @version 28/10-2025
 */

public class DieTest {
    /**
     * Fejl var at man glemte at tilføje en efter at have RandomNum sides, da den bruger 0 index.
     */
    @Test
    public void testDieRoll(){
        /// Assign
        for (int i = 2; i <= 10; i++) {
            Die d = new Die(i);
            Set<Integer> values = new HashSet<>();
            int sum = 0;

            ///  Act & Assert
            for (int j = 0; j < 100000; j++) {
                d.roll();
                int eyes = d.getEyes();
                Assertions.assertTrue(eyes >= 1 && eyes <= i);
                values.add(eyes);
                sum += eyes;
            }

            /// Assign
            int expectedSum = 100000 * (i+1)/2;

            /// Final asserts
            Assertions.assertEquals(i, values.size());
            Assertions.assertTrue(expectedSum * 0.99 <= sum && expectedSum * 1.01 >= sum); /// 1% margin.
        }
    }
}
