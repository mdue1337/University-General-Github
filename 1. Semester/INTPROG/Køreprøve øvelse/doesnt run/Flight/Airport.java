import java.util.*;

/**
 * Write a description of class Airport here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Airport
{
    private String name;
    private ArrayList<Flight> flights;
    
    public Airport(String name){
        this.name = name;
        flights = new ArrayList<>();
    }
    
    public void addFlight(Flight f){
        flights.add(f);
    }
    
    public int findSeats(String airline){
        int sum = 0;
        for(Flight f : flights){
            if(f.getAirline().equals(airline)){
                sum += f.getSeats();
            }
        }
        return sum;
    }
    
    public Flight fastFlightFrom(String airline){
        Flight fastest = null;
        for(Flight f : flights){
            if(f.getAirline().equals(airline) && (fastest == null || f.getSpeed() > fastest.getSpeed())){
                fastest = f;
            }
        }
        return fastest;
    }
    
    public void printAirport(){
        System.out.println(this.name);
        Collections.sort(flights);
        for(Flight f : flights){
            System.out.println(f.toString());
        }
    }
    
    public List<Flight> findFlights(int min, int max){    
        return this.flights.stream()
                .filter((Flight f) -> f.getSpeed() >= min && f.getSpeed() <= max)
                .toList();
    }
    
    public long fastFlights(int speed){
        return this.flights.stream()
                .filter(s -> s.getSpeed() >= speed)
                .count();
    }
}