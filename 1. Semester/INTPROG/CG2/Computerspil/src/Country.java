import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Represents a country with cities and roads.
 * It has a name, and network of nodes.
 * @author Martin Due & Mathias Bøttger
 * @version 03/11-2025
 */
public class Country {
    private String name;
    private Map<City, Set<Road>> network;
    private Game game;

    /**
     * Creates an empty country
     *
     * @param name       the name of the country (non\-null)
     * @return The country object
     */
    public Country(String name) {
        this.name = name;
        this.network = new TreeMap<>();
    }

    /**
     * Returns the name of the country
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
    * Returns all the cities in the country
    * @return The cities
    */
    public Set<City> getCities(){
        return network.keySet();
    }

    /**
    * Returns a city with the given name
    * @param name       The name of the city 
    * @return The city with the provided 'name' if it is found - else null
    */
    public City getCity(String name){
        for(City city : getCities()){
            if(city.getName().equals(name)){
                return city;
            }
        }
        return null;
    }

    /**
    * Returns all the roads connected to the provided city
    * @param c The city used to search for roads
    * @return The roads connected to the provided city if it is found. Else an empty treeset is returned
    */
    public Set<Road> getRoads(City c){
        if(network.containsKey(c)){
            return network.get(c);
        }
        return new TreeSet<>();
    }

    /**
    * Returns the game object of the country
    * @return the game
    */
    public Game getGame(){
        return game;
    }

    /**
    * Resets all the cities in the country
    */
    public void reset(){
        for(City city : getCities()){
            city.reset();
        }
    }

    /**
    * Sets the game to the provided game object
    * @param game The game object
    */
    public void setGame(Game game){
        this.game = game;
    }

    /**
    * Calculates the bonus the player will recieve.
    * If the provided value is greater than 0, the player will recieve a random bonus between 0 and the provided value inclusive.
     * Else 0 is returned.
    * @param value The upper bound for the random returned bonus.
    * @return the calculated bonus.
    */
    public int bonus(int value){
        if(value > 0){
            return game.getRandom().nextInt(value+1);
        }
        return 0;
    }

    /**
    * Adds a city with no roads connected to the country
    * @param c The city to be added
    */
    public void addCity(City c){
        network.put(c, new TreeSet<>());
    }

    /**
    * Adds road(s) between a and b. a and b have to be differet.
    * <p>
    * There are only built roads from cities within the country.
     * If a and b are both in the country, roads are built both ways.
     * If one is outside the country, only a road going out is made.
     * Likewise, if no cities are in the country, no roads are made.
     * <p> Only roads with distance greater than 0 are built
     *
    * @param a City 1
    * @param b City 2
    * @param length The length of the road
    */
    public void addRoads(City a, City b, int length){
        if(length <= 0 || a.equals(b)) return;

        if(network.containsKey(a)){
            network.get(a).add(new Road(a, b, length));
        }
        if(network.containsKey(b)){
            network.get(b).add(new Road(b, a, length));
        }
    }

    /**
    * Returns the position from the provided city.
     * The position is from and to the provided city. The distance is then 0
    * @param city The city you want a position from
    * @return the position
    */
    public Position position(City city){
        return new Position(city, city, 0);
    }


    /**
    * Returns a position object indicating that the player is ready to travel from 'from' to 'to', but is currently standing in 'from'.
     * If 'from' equals 'to', the just a position from that city is returned.
     * Also the case if 'from' isnt in the country.
    * @param from The city where the position starts from
    * @param to The city where the position goes to
    * @return A position indicating the players position in a journey from 'from' to 'to' 
    */
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


    /**
     * returns the name of the country
     *
     * @return the name of the country
     */
    @Override
    public String toString(){
        return name;
    }


    /**
     * Indicates whether some other object is equal to this one.
     * <p>
     * To countries are equal if and only if they have the same name
     * </p>
     *
     * @param otherObject the reference object with which to compare
     * @return `true` if the specified object is equal to this position - otherwise `false`
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Country other = (Country)otherObject;
        return this.name.equals(other.getName());
    }

    /**
     * Returns a hash code value for the position, consistent with `equals`.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return 11 * name.hashCode();
    }
}
