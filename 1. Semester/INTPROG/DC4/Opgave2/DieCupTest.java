import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @author Martin Due & Mathias Bøttger
 * @version 28/10-2025
 */
public class DieCupTest {
    @Test
    public void roll(){
        Random random = new Random();
        ArrayList<Integer> sides = new ArrayList<>();
        int maxValue = 0;
        int sum = 0;

        ///  100 forskellige bærgere.
        for (int i = 0; i < 100; i++) {
            sides.clear();
            maxValue = 0;
            sum = 0;
            
            int numOfDice = random.nextInt(4) + 1;
            /// ACT
            for (int j = 0; j < numOfDice; j++) {
                int randomNum = random.nextInt(9) + 2;
                Assertions.assertTrue(randomNum >= 2 && randomNum <= 10);
                sides.add(randomNum);
                maxValue += randomNum;
            }
            DieCup dieCup = new DieCup(sides);

            for (int k = 0; k < 100000; k++) {
                dieCup.roll();
                int eyes = dieCup.getEyes();

                /// Assert
                Assertions.assertTrue(eyes >= (1*numOfDice) && eyes <= (maxValue));
                sum += eyes;
            }
            
            /// ACT
            int expectedSum = 100000 * (numOfDice + maxValue)/ 2;
            dieCup.resetMaxEyes();

            /// ASSERT
            Assertions.assertTrue(expectedSum * 0.99 <= sum && expectedSum * 1.01 >= sum);
            Assertions.assertEquals(0, dieCup.getMaxEyes());
        }
    }
}
