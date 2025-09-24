import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void exam(){
        WebShop shop = new WebShop("Telenor");
        
        Phone p1 = new Phone("Apple", "Iphone 17", 2025, 7499);
        Phone p2 = new Phone("Apple", "Iphone 16", 2024, 6499);
        Phone p3 = new Phone("Apple", "Iphone 15", 2023, 5499);
        Phone p4 = new Phone("Apple", "Iphone 14", 2022, 4499);
        Phone p5 = new Phone("Apple", "Iphone 13", 2021, 3499);
        
        shop.inventory.add(p1);
        shop.inventory.add(p2);
        shop.inventory.add(p3);
        shop.inventory.add(p4);
        shop.inventory.add(p5);
        
        shop.printWebShop();
    }
}