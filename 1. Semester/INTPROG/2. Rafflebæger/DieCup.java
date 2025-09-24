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
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup(int sides1, int sides2) {
        // Dont need to handle exception as it does so in the Die class
        d1 = new Die(sides1);
        d2 = new Die(sides2);
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
            temp += rollSum;
            double currentAverage = (double)temp / (i+1);
            System.out.println((i+1) + ". Roll was " + rollSum + ", current average is: " + currentAverage);
        }
        
        double finalAverage = (double)temp / noOfRolls;
        System.out.println("Average no of eyes for all " + noOfRolls + " rolls: " + finalAverage);
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