 

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @author Martin Due & Mathias Bøttger
 * @version 28/10-2025
 */
public class DieCupTest {
    @Test
    public void TestDiceCupRoll(){
         ///  Asign
        for (int i = 2; i <= 10; i++) {
            for (int j = 2; j <= 10; j++) {
                DieCup dieCup = new DieCup(i, j);
                Set<Integer> values = new HashSet<>();
                int sum = 0;

                ///  Act & Assert
                for (int k = 0; k < 100000; k++) {
                    int maxEyes = dieCup.getMaxEyes();
                    dieCup.roll();
                    int eyes = dieCup.getEyes();

                    /// Assert
                    Assertions.assertTrue(eyes >= 2 && eyes <= (j+i));
                    Assertions.assertEquals(Math.max(maxEyes, eyes), dieCup.getMaxEyes());

                    values.add(eyes);
                    sum += eyes;
                }

                /// Assign
                int expectedSum = 100000 * (i+j+2)/2;
                dieCup.resetMaxEyes();

                /// Final asserts
                Assertions.assertEquals(i+j-1, values.size());
                Assertions.assertTrue(expectedSum * 0.99 <= sum && expectedSum * 1.01 >= sum); /// 1% margin.
                Assertions.assertEquals(0, dieCup.getMaxEyes());
            }

        }
    }
}
