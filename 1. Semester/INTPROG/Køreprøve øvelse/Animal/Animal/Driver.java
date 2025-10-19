
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void exam(){
        Animal a1 = new Animal("Elephant", 20, 21);
        Animal a2 = new Animal("Tiger", 40, 2);
        Animal a3 = new Animal("Goat", 20, 100);
        Animal a4 = new Animal("Pigeon", 999, 999);
        Animal a5 = new Animal("Toad", 80, 210);
        
        System.out.println("Udskriver a1-a5: \n-------------");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
        System.out.println(a4.toString());
        System.out.println(a5.toString());
        
        Zoo zoo = new Zoo("CPH");
        zoo.add(a1);
        zoo.add(a2);
        zoo.add(a3);
        zoo.add(a4);
        zoo.add(a5);
        
        System.out.println("-------------");
        System.out.println("Amount of animals: " + zoo.animals());

        System.out.println("-------------");
        System.out.println("The animal with the largest population: " + zoo.largestPopulation().toString());
        
        System.out.println("-------------");
        zoo.printZoo();
    }
}