
/**
 * Write a description of class Turtle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Turtle
{
    private String name;
    private boolean isMale;
    private int age;
    
    public Turtle(String name, boolean isMale, int age){
        this.name = name;
        this.isMale = isMale;
        this.age = age;
    }
    
    public String toString(){
        String gender = isMale ? "male" : "female";
        return name + ": " + age + " years, " + gender;
    }
    
    public int getAge(){
        return age;
    }
    
    public boolean isMale(){
        return isMale;
    }
}