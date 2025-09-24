import java.util.*;

/**
 * Write a description of class ByAge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ByAge implements Comparator<Person>
{
    /**
     * Returnerer negativt hvis this < p, 
     * Returnerer 0 hvis this = p,
     * Returnerer positivt hvis this > p
     */
    
    public int compare(Person p1, Person p2){
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}