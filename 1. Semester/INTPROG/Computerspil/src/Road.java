// java
/**
 * Represents a directed road between two cities with an associated length.
 * <p>
 * Natural ordering sorts by `from` city, then `to` city, then `length`.
 * </p>
 * @author Martin Due & Mathias Bøttger
 * @version 04/11-2025
 */
public class Road implements Comparable<Road> {
    private City from;
    private City to;
    private int length;

    /**
     * Creates a road from one city to another.
     *
     * @param from   the origin city (non\-null)
     * @param to     the destination city (non\-null)
     * @param length the road length in arbitrary units
     */
    public Road(City from, City to, int length) {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    /**
     * Returns the origin city.
     *
     * @return the `from` city
     */
    public City getFrom() {
        return from;
    }

    /**
     * Returns the destination city.
     *
     * @return the `to` city
     */
    public City getTo() {
        return to;
    }

    /**
     * Returns the road length.
     *
     * @return the length in arbitrary units
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns a readable representation of the road in the form
     * `<from> -> <to> : <length>`
     *
     * @return string representation of this road
     */
    @Override
    public String toString() {
        return from.getName() + " (" + from.getValue() + ") -> " + to.getName() + " (" + to.getValue() + ") : " + length;
    }

    /**
     * Compares this road with another for ordering.
     * <p>
     * Sorts lexicographically by `from` city, then by `to` city, then by `length`.
     * </p>
     *
     * @param other the other road to compare
     * @return a negative, zero, or positive integer as this road is less than, equal to,
     *         or greater than the specified road
     */
    @Override
    public int compareTo(Road other){
        if(this.from == (other.getFrom())){
            if(this.to == other.getTo()){
                return Integer.compare(this.length, other.getLength());
            }
            return to.compareTo(other.getTo());
        }
        return from.compareTo(other.getFrom());
    }

    /**
     * Indicates whether some other object is equal to this one.
     * <p>
     * Two roads are equal if their `from` and `to` cities are equal (via `City.equals`)
     * and their `length` values are the same.
     * </p>
     *
     * @param otherObject the reference object with which to compare
     * @return `true` if the specified object is equal to this road; otherwise `false`
     */
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Road other = (Road) otherObject;
        return this.from.equals(other.getFrom()) &&
                this.to.equals(other.getTo()) &&
                this.length == other.length;
    }

    /**
     * Returns a hash code value for the road, consistent with `equals`.
     *
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return 11 * this.from.hashCode() +
                13 * this.to.hashCode() +
                17 * this.length;
    }
}
