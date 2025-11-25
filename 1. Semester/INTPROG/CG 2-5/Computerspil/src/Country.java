import java.util.*;

public class Country {
    private String name;
    private Map<City, Set<Road>> network;
    private Game game;

    public Country(String name) {
        this.name = name;
        this.network = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public Set<City> getCities(){
        return network.keySet();
    }

    public City getCity(String name){
        for(City city : getCities()){
            if(city.getName().equals(name)){
                return city;
            }
        }
        return null;
    }

    public Set<Road> getRoads(City c){
        if(network.containsKey(c)){
            return network.get(c);
        }
        return new TreeSet<>();
    }

    public Game getGame(){
        return game;
    }

    public void reset(){
        for(City city : getCities()){
            city.reset();
        }
    }

    public void setGame(Game game){
        this.game = game;
    }

    public int bonus(int value){
        if(value > 0){
            return game.getRandom().nextInt(value+1);
        }
        return 0;
    }

    public void addCity(City c){
        network.put(c, new TreeSet<>());
    }

    public void addRoads(City a, City b, int length){
        if(length <= 0 || a.equals(b)) return;

        if(this.equals(a.getCountry())){
            network.get(a).add(new Road(a, b, length));
        }
        if(this.equals(b.getCountry())){
            network.get(b).add(new Road(b, a, length));
        }
    }

    public Position position(City city){
        return new Position(city, city, 0);
    }

    public Position readyToTravel(City from, City to){
        if(from.equals(to)) return position(from);
        if(!equals(from.getCountry())) return position(from);

        for(Road r : getRoads(from)){
            if(r.getTo().equals(to)){
                return new Position(from, to, r.getLength());
            }
        }

        return position(from);
    }


    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Country other = (Country)otherObject;
        return this.name.equals(other.getName());
    }

    @Override
    public int hashCode() {
        return 11 * name.hashCode();
    }
}
