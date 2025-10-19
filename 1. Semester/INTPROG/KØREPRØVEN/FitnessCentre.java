import java.util.*;

/**
 * Write a description of class FitnessCentre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FitnessCentre
{
    private String street;
    private ArrayList<Athlete> athletes;
    
    public FitnessCentre(String street){
        this.street = street;
        athletes = new ArrayList<>();
    }
    
    public void addAthlete(Athlete a){
        athletes.add(a);
    }
    
    public ArrayList<Athlete> findAthletes(int min, int max){
        ArrayList<Athlete> found = new ArrayList<>();
        for(Athlete a : athletes){
            if(a.getWeight() <= max && a.getWeight() >= min){
                found.add(a);
            }
        }
        return found;
    }
    
    public Athlete heavyAthlete(String name){
        Athlete heaviest = null;
        for(Athlete a : athletes){
            if(heaviest == null || ( a.getName().equals(name) && a.getWeight() > heaviest.getWeight())){
                heaviest = a;
            }
        }
        return heaviest;
    }
    
    public void printFitnessCentre(){
        System.out.println(this.street);
        Collections.sort(athletes);
        for(Athlete a : athletes){
            System.out.println(a.toString());
        }
    }
    
    public int findWeight(boolean male){
        return athletes.stream()
        .filter( (Athlete a) -> a.isMale() == male)
        .mapToInt( (Athlete a) -> a.getWeight())
        .sum();
    }
    
    public long heavyAthletes(int minWeight){
        return athletes.stream()
        .filter( (Athlete a) -> a.getWeight() >= minWeight)
        .count();
    }
}