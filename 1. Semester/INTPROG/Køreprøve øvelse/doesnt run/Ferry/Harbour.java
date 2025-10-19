import java.util.*;

/**
 * Write a description of class Harbour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Harbour
{
    private String name;
    private ArrayList<Ferry> ferries;
    
    public Harbour(String name){
        this.name = name;
        ferries = new ArrayList<>();
    }
    
    public void addFerry(Ferry f){
        ferries.add(f);
    }
    
    public ArrayList<Ferry> smallFerries(int maxLength){
        ArrayList<Ferry> small = new ArrayList<>();
        for(Ferry f : ferries){
            if(f.getLength() <= maxLength){
                small.add(f);
            }
        }
        return small;
    }
    
    public Ferry longFerry(String name){
        Ferry longest = null;
        for(Ferry f : ferries){
            if(f.getName().equals(name) && (longest == null || f.getLength() > longest.getLength()) ){
                longest = f;
            }
        }
        return longest;
    }
    
    public void printHarbour(){
        System.out.println(this.name);
        Collections.sort(ferries);
        for(Ferry f : ferries){
            System.out.println(f.toString());
        }
    }

    public List<Ferry> findFerries(int min, int max){
        return ferries.stream()
        .filter((Ferry f) -> f.getWidth() >= min && f.getWidth() <= max ) 
        .toList();
    }
    
    public int findLength(String name){
        return (int)ferries.stream()
        .filter( (Ferry f) -> f.getName().equals(name) )
        .mapToInt(f -> f.getLength())
        .sum();
    }
}