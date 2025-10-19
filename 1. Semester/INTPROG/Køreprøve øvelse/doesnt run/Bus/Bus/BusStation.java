import java.util.*;

/**
 * Write a description of class BusStation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BusStation
{
    private String city;
    private ArrayList<Bus> busses;
    
    public BusStation(String city){
        this.city = city;
        busses = new ArrayList<>();
    }
    
    public void addBus(Bus b){
        busses.add(b);
    }
    
    public Bus largeBus(int minSeats){
        Bus largestB = null;
        for(Bus b : busses){
            if(b.getSeats() >= minSeats){return b;}
        }
        return largestB;
    }
    
    public Bus smallBusTo(String destination){
        Bus smallBus = null;
        for(Bus b : busses){
            if(b.getDestination().equals(destination) && (smallBus == null || b.getSeats() <= smallBus.getSeats() ) ){
                smallBus = b;
            }
        }
        return smallBus;
    }
    
    public void printBusStation(){
        System.out.println(this.city);
        Collections.sort(busses);
        for (Bus b : busses) {
            System.out.println(b.toString());
        }
    }
    
    public long bussesFrom(String departure){
        return busses.stream()
        .filter((Bus b) -> b.getDeparture().equals(departure) && b.getDestination().equals(this.city))
        .count();
    }
    
    public Bus findBus(int minSeats) {
        return busses.stream()
        .filter((Bus b) -> b.getSeats() >= minSeats)
        .findFirst()
        .orElse(null);
    }
}