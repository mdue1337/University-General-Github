
/**
 * Write a description of class TestDriver here.
 *
 * @author Martin Due & Mathias Møller Bøttger
 * @version ??
 */
public class TestDriver
{
    // instance variables - replace the example below with your own
    private static DieCup testCup;

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void test(int sides1, int sides2)
    {
        testCup = new DieCup(sides1, sides2);
        testCup.roll();
        int rollSum = testCup.getEyes();
        System.out.println("Roll was: " + rollSum);
    }
    
    public static void testMultiple(int noOfRolls, int sides1, int sides2)
    {
        testCup = new DieCup(sides1, sides2);
        testCup.multipleRolls(noOfRolls);
    }
    
    public static void compareDieCups(int s1, int s2, int s3, int s4, int noOfRolls)
    {
        DieCup c1 = new DieCup(s1, s2);
        DieCup c2 = new DieCup(s3, s4);
        
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
        
        System.out.println("DieCup 1 with " + s1 + " and " + s2 + " sides is highest: " + c1Win + " times");
        System.out.println("DieCup 2 with " + s3 + " and " + s4 + " sides is highest: " + c2Win + " times");
        System.out.println("Same score in both: " + draw + " times");
    }
}