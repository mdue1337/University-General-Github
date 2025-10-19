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
        Train t1 = new Train("Aarhus", "Odense", 150);
        Train t2 = new Train("Aarhus", "København", 200);
        Train t3 = new Train("Aarhus", "Aalborg", 300);
        Train t4 = new Train("Aarhus", "København", 400);
        Train t5 = new Train("Aarhus", "Odder", 50);
        
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        
        TrainStation centrum = new TrainStation("Aarhus");
        centrum.addTrain(t1);
        centrum.addTrain(t2);
        centrum.addTrain(t3);
        centrum.addTrain(t4);
        centrum.addTrain(t5);
        
        System.out.println("Connecting trains:");
        System.out.println(centrum.connectingTrains());
        
        System.out.println("Cheapest to København:");
        System.out.println(centrum.cheapTrainTo("København"));
        
        System.out.println("Printing station");
        centrum.printTrainStation();
        
        System.out.println("Trains from København");
        List<Train> from = centrum.trainsFrom("København");
        from.forEach(t -> System.out.println(t.toString()));
        
        System.out.println("Cheapest to København:");
        System.out.println(centrum.cheapTrain("København"));
    }
}