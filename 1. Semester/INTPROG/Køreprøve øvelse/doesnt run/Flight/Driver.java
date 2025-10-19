import java.util.*;

/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void exam(){
        Flight f1 = new Flight("SAS", 800, 100);
        Flight f2 = new Flight("KLM", 300, 70);
        Flight f3 = new Flight("DELTA", 1100, 200);
        Flight f4 = new Flight("LUFTHANSA", 700, 120);
        Flight f5 = new Flight("SAS", 600, 130);
        
        System.out.println("Printing flights:");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println(f4.toString());
        System.out.println(f5.toString());
        
        Airport airport = new Airport("CPH");
        airport.addFlight(f1);
        airport.addFlight(f2);
        airport.addFlight(f3);
        airport.addFlight(f4);
        airport.addFlight(f5);
        
        System.out.println("Getting seats for SAS:");
        System.out.println(airport.findSeats("SAS"));
        
        System.out.println("Getting fastest flight from SAS");
        System.out.println(airport.fastFlightFrom("SAS"));
        
        System.out.println("Printing airport");
        airport.printAirport();
        
        System.out.println("Printing flights between 700 and 1100 in speed");
        List<Flight> sortedFlights = airport.findFlights(700, 1100);
        sortedFlights.forEach(f -> System.out.println(f.toString()));
    }
}