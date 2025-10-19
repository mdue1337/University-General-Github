
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestDriver
{
    public static void exam(){
        Bus b1 = new Bus("Aarhus", "Odense", 40);
        Bus b2 = new Bus("Kobenhavn", "Odense", 100);
        Bus b3 = new Bus("Birkerod", "Odense", 200);
        Bus b4 = new Bus("Hillerod", "Jagerspris", 20);
        Bus b5 = new Bus("Aarhus", "Kobenhavn", 300);
        
        System.out.println("Printing all busses: ");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        System.out.println(b4.toString());
        System.out.println(b5.toString());
        
        BusStation main = new BusStation("Aarhus");
        main.addBus(b1);
        main.addBus(b2);
        main.addBus(b3);
        main.addBus(b4);
        main.addBus(b5);
        
        System.out.println("First bus that has atleast 100 seats");
        Bus largest = main.largeBus(100);
        System.out.println(largest.toString());
        
        System.out.println("Smallest bus to Odense");
        Bus smallest = main.smallBusTo("Odense");
        System.out.println(smallest.toString());
        
        System.out.println("Printing station:");
        main.printBusStation();
        
        System.out.println("Sum of BussesFrom Aarhus to Odense (our station)");
        System.out.println(main.bussesFrom("Aarhus"));
        
        System.out.println("First bus with min 300 seats");
        System.out.println(main.findBus(300));
    }
}