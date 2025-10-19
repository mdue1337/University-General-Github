
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    static void exam(){
        Vegetable v1 = new Vegetable("Carrot", true, 50);
        Vegetable v2 = new Vegetable("Carrot", false, 200);
        Vegetable v3 = new Vegetable("Apple", true, 150);
        Vegetable v4 = new Vegetable("Beetroot", true, 100);
        Vegetable v5 = new Vegetable("Coconut", false, 300);
        
        System.out.println("Printing vegetables: \n ------------");
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
        System.out.println(v4.toString());
        System.out.println(v5.toString());
        
        Shop kiosk = new Shop("Martin");
        kiosk.add(v1);
        kiosk.add(v2);
        kiosk.add(v3);
        kiosk.add(v4);
        kiosk.add(v5);
        
        System.out.println("Find first organic, and first non-organic \n----------");
        System.out.println(kiosk.find(true));
        System.out.println(kiosk.find(false));
        
        System.out.println("Is shop mostly organic? \n-----------");
        System.out.println(kiosk.organic());
        
        System.out.println("Print shop sorted alphabetically, or by number from high to low \n------------");
        kiosk.printShop();
    }
}