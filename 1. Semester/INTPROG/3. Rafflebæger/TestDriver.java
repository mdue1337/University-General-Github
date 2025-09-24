/**
 * Write a description of class TestDriver here.
 *
 * @author Martin Due & Mathias Møller Bøttger
 * @version ??
 */

import java.util.ArrayList;

public class TestDriver
{
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void test(ArrayList<Integer> noOfDice)
    {
        DieCup testCup = new DieCup(noOfDice);
        testCup.roll();
        int rollSum = testCup.getEyes();
        System.out.println("Roll was: " + rollSum);
    }
    
    public static void test4638(int noOfRolls)
    {
        ArrayList<Integer> newDice = new ArrayList<>();
        newDice.add(4);
        newDice.add(6);
        newDice.add(3);
        newDice.add(8);
        
        testMultiple(newDice, noOfRolls);
    }
    
    public static void testMultiple(ArrayList<Integer> noOfDice, int noOfRolls)
    {
        DieCup testCup = new DieCup(noOfDice);
        int temp = 0;
        int rollSum = 0;
        
        for(int i = 0; noOfRolls > i; i++)
        {
            testCup.roll();
            rollSum = testCup.getEyes();
            temp += rollSum;
            double currentAverage = (double)temp / (i+1);
            System.out.println((i+1) + ". Roll was " + rollSum);
        }
        
        double finalAverage = (double)temp / noOfRolls;
        System.out.println("Average no of eyes: " + noOfRolls + " rolls: " + finalAverage);
    }
    
    public static void TestCompareDieCups()
    {
        ArrayList<Integer> d1 = new ArrayList<>(){
            {
                add(6);
                add(6);
                add(6);
            }
        };
        
        ArrayList<Integer> d2 = new ArrayList<>(){
            {
                add(2);
                add(8);
                add(5);
                add(3);
            }
        };
        
        compareDieCups(d1, d2, 100);        
    }
        
    public static void compareDieCups(ArrayList<Integer> d1, ArrayList<Integer> d2, int noOfRolls)
    {
        DieCup c1 = new DieCup(d1);
        DieCup c2 = new DieCup(d2);
        
        // store values for tracking count of wins
        int c1Win = 0;
        int c2Win = 0;
        int draw = 0;
        
        for (int i = 0; noOfRolls > i; i++)
        {
            c1.roll(); 
            c2.roll();
            
            int c1EyesCount = c1.getEyes();
            int c2EyesCount = c2.getEyes();
            
            if(c1EyesCount > c2EyesCount)
            {
                c1Win += 1;
            }
            else if(c2EyesCount > c1EyesCount)
            {
                c2Win += 1;
            }
            else
            {
                draw += 1;
            }
        }
        
        System.out.println("DieCup 1 with " + d1 + " sides is highest: " + c1Win + " times");
        System.out.println("DieCup 2 with " + d2 + " sides is highest: " + c2Win + " times");
        System.out.println("Same score in both: " + draw + " times");
    }
    
    public static ArrayList<Integer> createArrayList(int digits)
    {
        ArrayList<Integer> output = new ArrayList();
        
        while(digits > 0){
            int remainder = digits % 10;
            output.add(remainder);
            System.out.println(remainder);
            digits /= 10;
        }
        
        return output;
    }
}