
/**
 * Write a description of class Train here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Train implements Comparable<Train>
{
    private String departure;
    private String destination;
    private int price;
    
    public Train(String departure, String destination, int price){
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }
    
    public String getDeparture(){
        return this.departure;
    }
    
    public String getDestination(){
        return this.destination;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public String toString(){
        return "From " + this.departure + " to " + this.destination + " for " + this.price + " DKK";
    }
    
    public int compareTo(Train t){
        if(this.departure.equals(t.getDeparture())){ return this.price - t.getPrice(); }
        return this.departure.compareTo(t.getDeparture());
    }
}