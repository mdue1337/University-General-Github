 

/**
 * This class models a DieCup (raflebæger).
 * 
 * @author Kurt Jensen.
 * @version 2020-10-21.
 */
public class DieCup {
    private Die d1;        // First die
    private Die d2;        // Second die
    private int maxEyes;   // Maximum number of eyes up to now

    /**
     * Constructor for DieCup objects
     */
    public DieCup(int sides1, int sides2) {
        d1 = new Die(sides1);
        d2 = new Die(sides2);
    }

    /**
     * Obtain a new number of eyes for both dies
     */
    public void roll() {
        d1.roll();
        d2.roll();
        int eyes = getEyes();
        if(eyes > maxEyes) {
            maxEyes = eyes; 
        }
    }

    /**
     * Return the sum of the number of eyes shown by the two dies
     */
    public int getEyes() {
        return d1.getEyes() + d2.getEyes();
    }

    /**
     * Return the maximal number of eyes shown up to now
     */
    public int getMaxEyes() {
        return maxEyes;
    }

    /**
     * Reset the maximal number of eyes shown up to now
     */
    public void resetMaxEyes() {
        maxEyes = 0;
    }

}
