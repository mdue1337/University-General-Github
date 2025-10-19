import java.util.*;
/**
 * Write a description of class Family here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Family
{
    private String city;
    private ArrayList<Cat> cats;
    
    public Family(String city){
        this.city = city;
        cats = new ArrayList<>();
    }
    
    public void addCat(Cat c){
        cats.add(c);
    }
    
    public ArrayList<Cat> largeCats(int minWeight){
        ArrayList<Cat> largeCats = new ArrayList<>();
        for(Cat c : cats){
            if(c.getWeight() >= minWeight){
                largeCats.add(c);
            }
        }
        return largeCats;
    }
    
    public Cat heavyCat(String colour){
        Cat heaviest = null;
        for(Cat c : cats){
            if(c.getColour().equals(colour) && ( heaviest == null || (c.getWeight() > heaviest.getWeight())) ){
                heaviest = c;
            }
        }
        return heaviest;
    }
    
    public void printFamily(){
        System.out.println(this.city);
        Collections.sort(cats);
        for(Cat c : cats){
            System.out.println(c.toString());
        }
    }
    
    public List<Cat> findCats(String name){
        return cats.stream()
        .filter( (Cat c) -> c.getName().equals(name) )
        .toList();
    }
    
    public int findWeight(String colour){
        return cats.stream()
        .filter( (Cat c) -> c.getColour().equals(colour) )
        .mapToInt( (Cat c) -> c.getWeight() )
        .sum();
    }
}