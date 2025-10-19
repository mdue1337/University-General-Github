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
        Cat c1 = new Cat("Misse", 2, "Red");
        Cat c2 = new Cat("Peter", 7, "Red");
        Cat c3 = new Cat("Martin", 1, "Blue");
        Cat c4 = new Cat("Martin", 3, "Yellow");
        Cat c5 = new Cat("Fillip", 8, "Black");
        
        System.out.println("Print all cats");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println(c5.toString());
        
        Family cats = new Family("Aarhus");
        cats.addCat(c1);
        cats.addCat(c2);
        cats.addCat(c3);
        cats.addCat(c4);
        cats.addCat(c5);
        
        System.out.println("Find all cats larger than or equal to 2 kg");
        ArrayList<Cat> largeCats = cats.largeCats(2);
        for(Cat c : largeCats){
            System.out.println(c.toString());        
        }
        
        System.out.println("Heaviest cat:");
        System.out.println(cats.heavyCat("Black").toString());
        
        System.out.println("Family printed:");
        cats.printFamily();
        
        System.out.println("All cats with name Martin");
        List<Cat> Martin = cats.findCats("Martin");
        Martin.forEach(c -> System.out.println(c.toString()));
        
        System.out.println("Weight of cats with colour Red");
        System.out.println(cats.findWeight("Red"));
    }
}