/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Martin Due & Mathias Møller Bøttger
 * @version 2025-08-26
 **/
 
public class DieCup {
    private Die d1;   // First die
    private Die d2;   // Second die 
    private int rollSum; // Current roll
    private int maxSum; // Max roll yet
    private double averageSum; // Used to calculate average sum after 
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup() {
        d1 = new Die();
        d2 = new Die();
    }
    
     /**
     * Obtain a new number of eyes for both dice
     */
    public void roll() {
        d1.roll();
        d2.roll();
        rollSum = getEyes();
        
        if(rollSum > maxSum)
        {
            maxSum = rollSum;
        }
    }
    
    public void multipleRolls(int noOfRolls)
    {
        int temp = 0;
        
        for(int i = 0; noOfRolls > i; i++)
        {
            roll();
            System.out.println((i+1) + ". Roll was " + rollSum);
            temp += rollSum;
        }
        
        averageSum = temp / noOfRolls; // calc average.
        
        System.out.println("Average sum was: " + averageSum);
    }
    
    /**
     * Return the sum of the number of eyes shown by the two dice
     */
    public int getEyes() {
        return d1.getEyes() + d2.getEyes();
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
