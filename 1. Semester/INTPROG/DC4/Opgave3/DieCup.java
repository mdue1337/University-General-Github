import java.util.ArrayList;
/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Kurt Jensen
 * @version 2020-07-15
 */
public class DieCup {
    private ArrayList<Die> dies;   // List of dice
    private int maxEyes;           // Maximum number of eyes up to now

    /**
     * Constructor for DieCup objects
     */
    public DieCup(ArrayList<Integer> newDies) {
        if(newDies.size() < 1) {
            System.out.println("There must be at least one die");
        }
        else {
            dies = new ArrayList<>();
            for(Integer i : newDies) {
                dies.add(new Die(i));
            }
        }
    }

    /**
     * Obtain a new number of eyes for all dies
     */
    public void roll() {
        for(Die die : dies) {
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
        for(Die die : dies) {
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
