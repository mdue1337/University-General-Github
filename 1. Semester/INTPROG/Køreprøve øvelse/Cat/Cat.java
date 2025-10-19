
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat implements Comparable<Cat>
{
    private String name;
    private int weight;
    private String colour;
    
    public Cat(String name, int weight, String colour){
        this.name = name;
        this.weight = weight;
        this.colour = colour;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public String getColour(){
        return this.colour;
    }
    
    public String toString(){
        return name + ", " + weight + " kg, " + colour;
    }
    
    public int compareTo(Cat c){
        if(this.name.equals(c.getName())){ return this.weight - c.getWeight();}
        return this.name.compareTo(c.getName());
    }
}