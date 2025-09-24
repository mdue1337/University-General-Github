import java.util.ArrayList;

/**
 * Write a description of class Zoo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Zoo
{
    private String name;
    private ArrayList<Turtle> animals;
    
    public Zoo(String name){
        this.name = name;
        animals = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public void add(Turtle t){
        animals.add(t);
    }
    
    public void remove(Turtle t){
        animals.remove(t);
    }
    
    public Turtle oldestTurtle(){
        int age = 0;
        Turtle oldest = null;
        for(Turtle t : animals){
            int tAge = t.getAge();
            if(tAge > age){
                oldest = t;
                age = tAge;
            }
        }
        
        return oldest; 
    }
    
    public void killOldestTurtle(){
        Turtle t = oldestTurtle();
        System.out.println(t.toString() + " døde i nat -_-");
        animals.remove(t);
    }
    
    public void printZoo(){
        System.out.println(getName());
        animals.sort((t1, t2) -> Integer.compare(t1.getAge(), t2.getAge()));
        
        animals.sort((t1, t2) -> {
            int ageCompare = Integer.compare(t1.getAge(), t2.getAge());
            if (ageCompare != 0) {
                return ageCompare;
            }
            
            return Boolean.compare(t1.isMale(), t2.isMale());
        });
        
        for(Turtle t : animals){
            System.out.println(t.toString());
        }
    }
}