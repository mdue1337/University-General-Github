import java.util.*;

/**
 * Write a description of class ByName here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ByName implements Comparator<Person>
{
    /**
     * Returnerer negativt hvis this < p, 
     * Returnerer 0 hvis this = p,
     * Returnerer positivt hvis this > p
     */
    public int compare(Person p1, Person p2){
        return p1.getName().compareTo(p2.getName());
    }
}