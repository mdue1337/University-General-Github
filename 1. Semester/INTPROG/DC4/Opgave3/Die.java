// import class for generation of random numbers
import java.util.Random;
/**
 * This class models a Die (terning)
 * 
 * @author Kurt Jensen
 * @version 2020-07-15
 */
public class Die {
    private Random random;   // Used for generation of random numbers
    private int eyes;        // Number of eyes shown
    private int sides;       // No of sides

    /**
     * Constructor for Die objects
     */
    public Die(int noOfSides) {
        if(noOfSides < 2) {
            System.out.println("A die must have at least two sides");
        }
        else {
            random = new Random();
            sides = noOfSides;
            roll();
        }
    }

    /**
     * Obtain a new number of eyes for this die
     */
    public void roll() {
        eyes = random.nextInt(sides) + 1;
    }

    /**
     * Return the number of eyes shown by this die
     */
    public int getEyes() {
        return eyes;
    }
}
