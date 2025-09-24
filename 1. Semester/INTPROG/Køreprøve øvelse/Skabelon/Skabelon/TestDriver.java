import java.util.*;

/**
 * Write a description of class TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestDriver
{
    public static void exam(){
        ArrayList<String> list;
        list = new ArrayList<>();
        
        // Få min og max
        String min = Collections.min(list);
        String max = Collections.max(list);
        
        // Sorter efter alphabetisk?
        Collections.sort(list);
        
        // Shuffle liste
        Collections.shuffle(list);
        
        // Vend liste om
        Collections.reverse(list);
        
        ArrayList<Person> persons = new ArrayList<>();
         
        // Sorter efter navn
        Collections.sort(persons, new ByName());
        
        // Sorter efter alder
        Collections.sort(persons, new ByAge());
        
        // Sorter efter alder og så navn
        Collections.sort(persons, new ByAgeName());
    }
}