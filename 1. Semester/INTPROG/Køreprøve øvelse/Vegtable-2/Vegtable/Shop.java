import java.util.*;

/**
 * Write a description of class Shop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shop
{
    private String owner;
    private ArrayList<Vegetable> inventory;
    
    public Shop(String owner){
        this.owner = owner;
        inventory = new ArrayList<>();
    }
    
    public void add(Vegetable v){
        inventory.add(v);
    }
    
    public Vegetable find(boolean organic){
        Vegetable v = null;
        for(Vegetable i : inventory){
            if(i.getOrganic() == organic){
                return i;
            }
        }
        return v;
    }
    
    public boolean organic(){
        int sumOrganic = 0;
        int sumNonOrganic = 0;
        
        for(Vegetable v : inventory){
            if(v.getOrganic()){
                sumOrganic += v.getNumber();
            }
            else{
                sumNonOrganic += v.getNumber();
            }
        }
    
        return sumOrganic > sumNonOrganic;
    }
    
    public void printShop(){
        System.out.println(this.owner);
        Collections.sort(inventory);
        for(Vegetable v : inventory){
            System.out.println(v.toString());
        }
    }
}