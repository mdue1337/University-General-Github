import java.util.*;

/**
 * Write a description of class Forest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Forest
{
    private String country;
    private ArrayList<Tiger> tigers;
    
    public Forest(String country){
        this.country = country;
        tigers = new ArrayList<>();
    }
    
    public void addTiger(Tiger t){
        tigers.add(t);
    }
    
    public ArrayList<Tiger> findTigers(int min, int max){
        ArrayList<Tiger> findTigers = new ArrayList<>();
        
        for(Tiger t : tigers){
            if(t.getWeight() >= min && t.getWeight() <= max){
                findTigers.add(t);
            }
        }
        
        return findTigers;
    }
    
    public Tiger smallTiger(boolean male){
        Tiger small = null;
        
        for(Tiger t : tigers){
            if(t.isMale() == male && (small == null || t.getWeight() < small.getWeight())){
                small = t;
            }
        }
        
        return small;
    }
    
    public void printForest(){
        System.out.println(this.country);
        Collections.sort(tigers);
        for(Tiger t : tigers){
            System.out.println(t.toString());
        }
    }
    
    public long heavyTigers(int minWeight){
        return tigers.stream()
        .filter( (Tiger t) ->  t.getWeight() >= minWeight)
        .count();
    }
    
    public int findWeight(boolean male){
        return tigers.stream()
        .filter( (Tiger t) ->  t.isMale() == male)
        .mapToInt( (Tiger t) -> t.getWeight() )
        .sum();
    }
}