/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Martin Due & Mathias Møller Bøttger
 * @version 2025-08-26
 **/

import java.util.ArrayList;

public class DieCup {
    private ArrayList<Die> dice;   // First die
    private int rollSum; // Current roll
    private int maxSum; // Max roll yet
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup(ArrayList<Integer> newDice) {
        if (newDice == null || newDice.isEmpty()) {
            throw new IllegalArgumentException("There must be at least 1 die");
        }
    
        dice = new ArrayList<>();
        for (int value : newDice) {
            Die temp = new Die(value);
            dice.add(temp);
        }
    }
    
     /**
     * Obtain a new number of eyes for both dice
     */
    public void roll() {
        for(Die d : dice){
            d.roll();
        }
        
        rollSum = getEyes();
        
        if(rollSum > maxSum)
        {
            maxSum = rollSum;
        }
    }
    
    /**
     * Return the sum of the number of eyes shown by the two dice
     */
    public int getEyes() {
        rollSum = 0;
        for(Die d : dice){
            rollSum += d.getEyes();
        }
        return rollSum;
    }
    
    public int getMaxEyes()
    {
        return maxSum;
    }
    
    public void resetMaxEyes()
    {
        maxSum = 0;
    }
}