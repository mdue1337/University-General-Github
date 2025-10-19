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
        Tiger t1 = new Tiger(false, 100, "yellow");
        Tiger t2 = new Tiger(true, 125, "brown");
        Tiger t3 = new Tiger(true, 120, "black");
        Tiger t4 = new Tiger(false, 200, "red");
        Tiger t5 = new Tiger(true, 50, "yellow");
        
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        
        Forest forest = new Forest("Nambia");
        forest.addTiger(t1);
        forest.addTiger(t2);
        forest.addTiger(t3);
        forest.addTiger(t4);
        forest.addTiger(t5);
        
        System.out.println("Finding tigers between 100 and 200");
        ArrayList<Tiger> tigers = forest.findTigers(100, 200);
        for(Tiger t : tigers){
            System.out.println(t.toString());
        }
        
        System.out.println("Find smallest male");
        System.out.println(forest.smallTiger(true).toString());
        
        System.out.println("Printing forest");
        forest.printForest();
        
        System.out.println("Antal Minimum har vægten 100");
        System.out.println(forest.heavyTigers(100));
        
        System.out.println("Total weight of all females");
        System.out.println(forest.findWeight(false));
    }
}