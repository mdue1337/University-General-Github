import java.util.*;

/**
 * Write a description of class TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestDriver
{
    public static void exam(){
        Athlete a1 = new Athlete("Peter", true, 110);
        Athlete a2 = new Athlete("Peter", true, 80);
        Athlete a3 = new Athlete("Anna", false, 110);
        Athlete a4 = new Athlete("Martin", true, 75);
        Athlete a5 = new Athlete("Katherine", true, 50);
        
        System.out.println("Printing all athletes");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
        System.out.println(a4.toString());
        System.out.println(a5.toString());
        
        FitnessCentre puregym = new FitnessCentre("Uniparken 9");
        puregym.addAthlete(a1);
        puregym.addAthlete(a2);
        puregym.addAthlete(a3);
        puregym.addAthlete(a4);
        puregym.addAthlete(a5);
        
        System.out.println("All athletes betweeen 80 and 110");
        ArrayList<Athlete> found = puregym.findAthletes(80, 110);
        for(Athlete a : found){
            System.out.println(a.toString());
        }
        
        System.out.println("Heaviest named Peter");
        System.out.println(puregym.heavyAthlete("Peter"));
        
        System.out.println("Printing centre");
        puregym.printFitnessCentre();
        
        System.out.println("Sum of weight for all males:");
        System.out.println(puregym.findWeight(true));
        
        System.out.println("Num of athletes over 75kg");
        System.out.println(puregym.heavyAthletes(75));
    }
}