import java.util.*;

/**
 * Write a description of class TrainStation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TrainStation
{
    private String name;
    private ArrayList<Train> trains;
    
    public TrainStation(String name){
        this.name = name;
        trains = new ArrayList<>();
    }
    
    public void addTrain(Train t){
        trains.add(t);
    }
    
    public int connectingTrains(){
        int sum = 0;
        for(Train t : trains){
            if(t.getDestination().equals(this.name) || t.getDeparture().equals(this.name)){
                sum++;
            }
        }
        return sum;
    }
    
    public Train cheapTrainTo(String destination){
        Train cheapest = null;
        for(Train t : trains){
            if(t.getDestination().equals(destination) && (cheapest == null || t.getPrice() < cheapest.getPrice())){
                cheapest = t;
            }
        }
        return cheapest;
    }
    
    public void printTrainStation(){
        System.out.println(this.name);
        Collections.sort(trains);
        for(Train t : trains){
            System.out.println(t.toString());
        }
    }
    
    public List<Train> trainsFrom(String departure){
        return trains.stream()
        .filter ((Train t) -> t.getDeparture().equals(departure) && t.getDestination().equals(this.name))
        .toList();
    }
    
    public Train cheapTrain(String destination){
        return trains.stream()
        .filter((Train t) -> t.getDestination().equals(destination) && t.getDeparture().equals(this.name))
        .min(Comparator.comparing( (Train t) -> t.getPrice()))
        .orElse(null);
    }
}