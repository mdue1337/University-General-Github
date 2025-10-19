
/**
 * Write a description of class Animal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animal implements Comparable<Animal>
{
    private String name;
    private int females;
    private int males;
    
    public Animal(String name, int females, int males){
        this.name = name;
        this.females = females;
        this.males = males;
    }
    
    public String toString(){
        return name + ": " + females + " female and " + males + " male";
    }
    
    public int getFemales(){
        return this.females;
    }
    
    public int getMales(){
        return this.males;
    }
    
    public int compareTo(Animal a){
        if(this.females == a.getFemales()){
            return a.getMales() - this.males;
        }
        return  a.getFemales() - this.females;
    }
}