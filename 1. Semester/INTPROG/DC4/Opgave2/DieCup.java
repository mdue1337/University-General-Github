import java.util.ArrayList;
/**
 * This class models a DieCup (raflebæger).
 * 
 * @author Kurt Jensen.
 * @version 2020-10-21.
 */
public class DieCup {
    private ArrayList<Die> dice;   // List of dice
    private int maxEyes;           // Maximum number of eyes up to now

    /**
     * Constructor for DieCup objects
     */
    public DieCup(ArrayList<Integer> newDice) {
        if(newDice.size() < 1) {
            System.out.println("There must be at least one die");
        }
        else {
            dice = new ArrayList<>();
            for(Integer i : newDice) {
                dice.add(new Die(i));
            }
        }
    }

    /**
     * Obtain a new number of eyes for all dies
     */
    public void roll() {
        for(Die die : dice) {
            die.roll(); 
        }
        int eyes = getEyes();       
        if(eyes > maxEyes) {      
            maxEyes = eyes;
        }
    }

    /**
     * Return the sum of the number of eyes shown by all dies
     */
    public int getEyes() {
        int eyes = 0;
        for(Die die : dice) {
            eyes = eyes + die.getEyes(); 
        }
        return eyes;
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
