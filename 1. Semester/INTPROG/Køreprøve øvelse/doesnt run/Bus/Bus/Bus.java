import java.util.*;

/**
 * Write a description of class Bus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bus implements Comparable<Bus>
{
    private String departure;
    private String destination;
    private int seats;
    
    public Bus(String departure, String destination, int seats){
        this.departure = departure;
        this.destination = destination;
        this.seats = seats;
    }
    
    public String toString(){
        return departure + " --> " + destination + " with " + seats + " seats";
    }
    
    public String getDestination(){
        return this.destination;
    }
    
    public String getDeparture(){
        return this.departure;
    }
    
    public int getSeats(){
        return this.seats;
    }
    
    public int compareTo(Bus b){
        if(this.destination.equals(b.getDestination())){
            return this.seats - b.getSeats();
        }
        return this.destination.compareTo(b.getDestination());
    }
}