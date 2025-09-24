import java.util.*;

/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void exam(){
        Nail n1 = new Nail("Steel", 2, 70);
        Nail n2 = new Nail("Zinc", 4, 70);
        Nail n3 = new Nail("Gold", 8, 120);
        Nail n4 = new Nail("Aluminium", 10, 30);
        Nail n5 = new Nail("Plastic", 2, 70);
        
        System.out.println("Printing all Nails:");
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        System.out.println(n3.toString());
        System.out.println(n4.toString());
        System.out.println(n5.toString());
        
        Box box = new Box("Box1");
        box.add(n1);
        box.add(n2);
        box.add(n3);
        box.add(n4);
        box.add(n5);
        
        System.out.println("--------------------------------------");
        System.out.println("Søm der minimum har diameter på 2 og længde på 70:");
        System.out.println(box.number(2, 70));
        
        System.out.println("--------------------------------------");
        System.out.println("Søm der har materialet Steel");
        ArrayList<Nail> nFind = box.find("Steel");
        for(Nail n : nFind){
            System.out.println(n);
        }
        
        System.out.println("--------------------------------------");
        System.out.println("Udskriver liste sorteret efter længde, ellers alfabetisk efter navn");
        box.printBox();
    }
}