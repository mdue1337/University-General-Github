
/**
 * Write a description of class Phone here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Phone
{
    private String brand;
    private String model;
    private int year;
    private int price;
    
    public Phone(String brand, String model, int year, int price){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    
    public String toString(){
        return "Brand: " + brand + ", Model: " + model + ", " + year + ", " + price + " kr.";
    }
    
    public int getPrice(){
        return price;
    }
}