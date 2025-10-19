
/**
 * Write a description of class Vegetable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vegetable implements Comparable<Vegetable>
{
    private String name;
    private boolean organic;
    private int number;
    
    public Vegetable(String name, boolean organic, int number){
        this.name = name;
        this.organic = organic;
        this.number = number;
    }
    
    public String toString(){
        if(organic){
            return number + " organic " + name;
        }
        return number + " non-organic " + name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public boolean getOrganic(){
        return this.organic;
    }
    
    public int compareTo(Vegetable v){
        if(this.name.equals(v.getName())){
            return v.getNumber() - this.number;
        }
        return this.name.compareTo(v.getName());
    }
}