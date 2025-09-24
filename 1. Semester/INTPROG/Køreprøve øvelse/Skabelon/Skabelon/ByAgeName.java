import java.util.*;

/**
 * Write a description of class ByAgeName here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ByAgeName implements Comparator<Person>
{
    /**
     * Returnerer negativt hvis this < p, 
     * Returnerer 0 hvis this = p,
     * Returnerer positivt hvis this > p
     * 
     * Hvis de er lige gamle, så sorterer efter navn i alphabetisk.
     */
    public int compare(Person p1, Person p2){
        if(p1.getAge() != p2.getAge()){return Integer.compare(p1.getAge(), p2.getAge());}
        return p1.getName().compareTo(p2.getName());
    }
}
