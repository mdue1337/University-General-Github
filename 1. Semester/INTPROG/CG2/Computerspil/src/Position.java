/**
 * Represents a players position.
 * Keeps track of where a player came from, where it is heading, the distance remaining, and the total distance between the cities.
 * @author Martin Due & Mathias Bøttger
 * @version 03/11-2025
 */
public class Position {
    private City from;
    private City to;
    private int distance;
    private int total;

    /**
     * Creates a player position
     *
     * @param from       the origin city (non\-null)
     * @param to         the destination city (non\-null)
     * @param distance   the distance remaining
     * @return The position object
     */
    public Position(City from, City to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.total = distance;
    }

    /**
     * Returns the city the player came from.
     *
     * @return the `from` city
     */
    public City getFrom() {
        return from;
    }

    /**
     * Returns the city that the player is heading towards.
     *
     * @return the `to` city
     */
    public City getTo() {
        return to;
    }

    /**
     * Returns the distance remaining to the 'to' city
     *
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Returns the total distance between the 'from' and 'to' cities.
     *
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
    * Subtracts 1 from the distance - if distance is greater than 0
    *
    * @return true if distance was modified, else false
    */
    public boolean move(){
        if(distance > 0){
            distance -= 1;
            return true;
        }
        return false;
    }

    /**
    * Turns the player around, without moving it. 
    */
    public void turnAround(){
        City temp = from;
        from = to;
        to = temp;
        distance = total - distance;
    }

    /**
    * Indicates if the player has arrived at the destination city
    * @return true if distance is 0
    */
    public boolean hasArrived(){
        return distance == 0;
    }

    /**
     * Returns a readable representation of the position in the form
     * `<from> -> <to> : <distance>/<total>`
     *
     * @return string representation of this position
     */
    @Override
    public String toString() {
        return from.toString() + " -> " + to.toString() + " : " + distance + "/" + total;
    }

    /**
     * Indicates whether some other object is equal to this one.
     * <p>
     * Two positions are equal if their `from` and `to` cities are equal (via `City.equals`)
     * and their `distance` and 'total' values are the same.
     * </p>
     *
     * @param otherObject the reference object with which to compare
     * @return `true` if the specified object is equal to this position - otherwise `false`
     */
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Position other = (Position)otherObject;
        return this.from.equals(other.getFrom()) &&
                this.to.equals(other.getTo()) &&
                this.distance == other.getDistance() &&
                this.total == other.total;
    }

    /**
     * Returns a hash code value for the position, consistent with `equals`.
     *
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return 11 * this.from.hashCode() +
                13 * this.to.hashCode() +
                17 * Integer.hashCode(this.distance) +
                19 * Integer.hashCode(total);
    }
}

