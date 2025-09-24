
/**
 * Write a description of class Exam here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void exam(){
        Turtle t1 = new Turtle("Simon", true, 19);
        Turtle t2 = new Turtle("Simone", false, 20);
        Turtle t3 = new Turtle("Frederik", true, 20);
        Turtle t4 = new Turtle("Frederikke", false, 22);
        Turtle t5 = new Turtle("Jeppe", true, 14);
        
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        System.out.println("-------------");
        
        Zoo z = new Zoo("Lalandia");
        z.add(t1);
        z.add(t2);
        z.add(t3);
        z.add(t4);
        z.add(t5);
        
        System.out.println("Oldest turtle " + z.oldestTurtle());
        System.out.println("-------------");
        
        z.killOldestTurtle();
        System.out.println("-------------");
        
        z.printZoo();
    } 
}