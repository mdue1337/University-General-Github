import java.util.ArrayList;

/**
 * Write a description of class WebShop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WebShop
{
    private String name;
    public ArrayList<Phone> inventory;
    
    public WebShop(String name){
        this.name = name;
        inventory = new ArrayList();
    }
    
    private void add(Phone p){
        inventory.add(p);
    }
    
    public Phone phoneInPriceRange(int low, int high){
        for(Phone p : inventory){
            int price = p.getPrice();
            if(price >= low && price <= high){
                return p;
            }
        }
        return null;
    }
    
    public Phone cheapestPhone(){
        if(inventory.size() == 0){ return null; }
        
        Phone lowestPrice = inventory.get(0);
        for(Phone p : inventory){
            if(p.getPrice() < lowestPrice.getPrice()){
                lowestPrice = p;
            }
        }
        return lowestPrice;
    }
    
    public void printWebShop(){
        System.out.println("Shop name: " + name);
        
        for (int i = 0; i < inventory.size() - 1; i++) {
                for (int j = 0; j < inventory.size() - i - 1; j++) {
                if (inventory.get(j).getPrice() > inventory.get(j + 1).getPrice()) 
                {
                    Phone temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }   
        }
        
        for(Phone p : inventory){
            System.out.println(p);
        }
    }
}