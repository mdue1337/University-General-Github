// Import class for generation of random numbers
import java.util.Random;
import java.lang.Exception;
 
/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Martin Due & Mathias Møller Bøttger
 * @version 2025-08-26
 **/
public class Die 
{
    private Random random;   // Used for generation of random numbers
    private int eyes;  // Number of eyes shown
    private int sides; 
 
    /**
     * Constructor for Die objects
     */
    public Die(int noOfSides){
        random = new Random();
        
        if(noOfSides >= 2)
        {
            sides = noOfSides;
        }
        else
        {
            throw new IllegalArgumentException("Must have atleast 2 sides");
        }
        
        roll();
    }
 
    /**
     * Obtain a new number of eyes for this die
     */
    public void roll() {
        eyes = random.nextInt(sides) + 1; // Fordi starter p? [0, bound]
    }
 
    /**
     * Return the number of eyes shown by this die
     */
    public int getEyes() {
        return eyes;
    }
}