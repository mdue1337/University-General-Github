
/**
 * Write a description of class Tiger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tiger implements Comparable<Tiger>
{
    private  boolean male;
    private int weight;
    private String colour;
    
    public Tiger(boolean male, int weight, String colour){
        this.male = male;
        this.weight = weight;
        this.colour = colour;
    }
    
    public String toString(){
        if(this.male){
            return weight + " kg " + colour + " male";
        }
        return weight + " kg " + colour + " female";
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public boolean isMale(){
        return male;
    }
    
    public String getColour(){
        return this.colour;
    }
    
    public int compareTo(Tiger t){
        if(this.colour.equals(t.getColour())){ return this.weight - t.getWeight(); }
        return this.colour.compareTo(t.getColour());
    }
}