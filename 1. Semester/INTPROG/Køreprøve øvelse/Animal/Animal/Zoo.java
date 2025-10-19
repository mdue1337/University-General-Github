import java.util.*;

/**
 * Write a description of class Zoo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Zoo
{
    private String name;
    private ArrayList<Animal> animals;
    
    public Zoo(String name){
        this.name = name;
        animals = new ArrayList<>();
    }
    
    public void add(Animal a){
        animals.add(a);
    }
    
    public int animals(){
        int sum = 0;
        for(Animal a : animals){
            if(a.getMales() > 0 && a.getFemales() > 0)
            sum += a.getMales()+a.getFemales();
        }
        return sum;
    }
    
    public Animal largestPopulation(){
        Animal largest = null;
        
        for(Animal a : animals){
            if( largest == null || a.getMales() + a.getFemales() > largest.getMales() + largest.getFemales() ){
                largest = a;
            }
        }
        
        return largest;
    }
    
    public void printZoo(){
        System.out.println(this.name);
        Collections.sort(animals);
        
        animals.forEach((Animal p) -> System.out.println(p));
    }
}