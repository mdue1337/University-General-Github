
/**
 * Write a description of class Athlete here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Athlete implements Comparable<Athlete>
{
    private String name;
    private boolean male;
    private int weight;
    
    public Athlete(String name, boolean male, int weight){
        this.name = name;
        this.male = male;
        this.weight = weight;
    }
    
    public String toString(){
        if(male){
            return weight + " kg male " + "(" + name + ")";
        }
        return weight + " kg female " + "(" + name + ")";
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isMale(){
        return this.male;
    }
    
    public int compareTo(Athlete a){
        if(this.weight == a.getWeight()){ return this.name.compareTo(a.getName());}
        return a.getWeight() - this.weight;
    }
}