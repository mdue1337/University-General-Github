import java.util.ArrayList;
/**
 * Class for conducting a DieCup game between the computer and a user.
 * 
 * @author Martin Due & Mathias Bøttger 
 * @version 2025-11-02
 */
public class Game
{
    /**
     * Constructor for objects of class TestDriver
     */
    public Game() {
        //nothing to be done
    }

    /**
     * Method for splitting an integer into digits and using these
     * to construct an arraylist with Integer elements 
     */
    private static ArrayList<Integer> createArrayList(int digits) {                
        ArrayList<Integer> result = new ArrayList<>();
        while(digits != 0) {
            result.add(digits % 10);   // Indsæt sidste ciffer i result
            digits = digits / 10;      // Fjern sidste ciffer          
        }
        return result;
    }

    /**
     * Method for playing a game between the computer and the user
     */
    public static int play(int digits) {
        ArrayList<Integer> dice = createArrayList(digits);

        // Throws for computer
        int computerResult = 0;        
        DieCup dieCup = new DieCup(dice);
        for(int i = 0; i < 3; i++) {
            dieCup.roll();
            int result = dieCup.getEyes();
            computerResult += result;
        }
        System.out.format("Computer: %4d eyes     ", computerResult);

        // Throws for user
        int userResult = 0;
        int n = 0;
        do{
            for(int i = 0; i < dice.size(); i++) { // Loop starts at 1.
                Die die = new Die(dice.get(i)); // Tog altid 0 værdi ikke i'te.
                die.roll();
                int result = die.getEyes();
                userResult += result;
                // i++; ingen grund til at increment 2 gange.
            }
            n++;
        } while(n < 3); 
        System.out.format("User: %4d eyes     ", userResult);
        
        // Find winner(s)
        System.out.print("Winner(s):  ");    
        if(computerResult >= userResult)
        {
            System.out.print("Computer  ");
        }
        if(computerResult <= userResult)
        {
            System.out.print("User  ");
        }
        System.out.println();

        // Return result
        return userResult;        // The returned value is used by the testserver
    }
}
