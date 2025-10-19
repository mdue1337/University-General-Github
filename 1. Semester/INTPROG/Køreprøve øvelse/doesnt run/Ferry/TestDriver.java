
/**
 * Write a description of class TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestDriver
{
    public static void exam(){
        Ferry f1 = new Ferry("Nautilus", 200, 50);
        Ferry f2 = new Ferry("Nautilus", 300, 200);
        Ferry f3 = new Ferry("Helsingborg", 100, 80);
        Ferry f4 = new Ferry("Berlin", 200, 100);
        Ferry f5 = new Ferry("Goteborg", 50, 50);
        
        System.out.println("Printing all ferrys");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println(f4.toString());
        System.out.println(f5.toString());
        
        Harbour port = new Harbour("Port");
        port.addFerry(f1);
        port.addFerry(f2);
        port.addFerry(f3);
        port.addFerry(f4);
        port.addFerry(f5);
        
        System.out.println("All ferries with maximum 100 length");
        System.out.println(port.smallFerries(100));
        
        System.out.println("Longest ferry from Nautilus");
        System.out.println(port.longFerry("Nautilus").toString());
        
        System.out.println("Printing Harbour.");
        port.printHarbour();
        
        System.out.println("findFerries within intervall 100 and 300");
        System.out.println(port.findFerries(100, 300));
        
        System.out.println("Total findLength for Nautilus");
        System.out.println(port.findLength("Nautilus"));
    }
}