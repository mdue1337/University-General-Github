
/**
 * Write a description of class Flight here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flight implements Comparable<Flight>
{
    private String airline;
    private int speed;
    private int seats;
    
    public Flight(String airline, int speed, int seats){
        this.airline = airline;
        this.speed = speed;
        this.seats = seats;
    }
    
    public String toString(){
        return airline + ", " + speed + " km/hour, " + seats + " seats";
    }
    
    public String getAirline(){
        return this.airline;
    }
    
    public int getSeats(){
        return this.seats;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public int compareTo(Flight f){
        if(this.airline.equals(f.getAirline())){ return f.seats - this.seats;}
        return this.airline.compareTo(f.getAirline());
    }
}