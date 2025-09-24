import java.util.*;

/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private int age;
    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public static Person findOldestPerson(ArrayList<Person> persons) {
        return Collections.max(persons, new ByAge());
    }
    
    public Person findFirstPerson(ArrayList<Person> persons) {
        return Collections.min(persons, new ByName());
    }
}