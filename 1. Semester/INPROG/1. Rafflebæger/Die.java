// Import class for generation of random numbers
import java.util.Random;

/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Martin Due & Mathias Møller Bøttger
 * @version 2025-08-26
 **/
public class Die {
    private Random random;   // Used for generation of random numbers
    private int eyes;        // Number of eyes shown

    /**
     * Constructor for Die objects
     */
    public Die() {
        random = new Random();
        roll();
    }

    /**
     * Obtain a new number of eyes for this die
     */
    public void roll() {
        eyes = random.nextInt(6) + 1; // Fordi starter på [0, bound]
    }

    /**
     * Return the number of eyes shown by this die
     */
    public int getEyes() {
        return eyes;
    }
}
