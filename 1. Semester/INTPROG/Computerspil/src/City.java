/**
 * Represents a city with an immutable `name` and a mutable `value`.
 * The `initialValue` stores the original `value` at construction time.
 * <p>
 * Comparison is based on `name` only, while equality considers both `name` and current `value`.
 * @author Martin Due & Mathias Bøttger
 * @version 03/11-2025
 */

public class City implements Comparable<City> {
    private String name;
    private int value;
    private int initialValue;
    private Country country;

    /**
     * Creates a new city.
     *
     * @param name  non-null city name
     * @param value initial value associated with this city
     * @param country non-null country name
     */
    public City(String name, int value, Country country){
        this.name = name;
        this.value = value;
        this.initialValue = value;
        this.country = country;
    }

    /**
     * Adjusts the current `value` by the given delta.
     *
     * @param amount delta to add to the current `value` (may be negative)
     */
    public void changeValue(int amount){
        this.value += amount;
    }

    /**
     * Resets the current `value` back to `initialValue`.
     */
    public void reset(){
        this.value = this.initialValue;
    }

    /**
     * Returns the city name.
     *
     * @return the non-null name of this city
     */
    public String getName(){
        return name;
    }

    public Country getCountry(){
        return country;
    }

    /**
     * Returns the current value.
     *
     * @return field value;
     */
    public int getValue(){
        return value;
    }

    /**
     * Returns the initial value.
     *
     * @return field initialValue
     */
    public int getInitialValue(){
        return initialValue;
    }


    public int arrive(){
        int bonus = country.bonus(value);
        value -= bonus;
        return bonus;
    }

    /**
     * Returns a string representation in the form `name (value)`.
     *
     * @return string representation of this city
     */
    @Override
    public String toString(){
        return name + " (" + value + ")";
    }

    /**
     * Compares this city with another by lexicographical order of `name`.
     *
     * @param c the other city to compare to (must be non\-null)
     * @return a negative integer, zero, or a positive integer as this name
     *         is less than, equal to, or greater than the other name
     * @throws NullPointerException if `c` is `null`
     */
    @Override
    public int compareTo(City c) {
        return name.compareTo(c.getName());
    }

    /**
     * Indicates whether some other object is equal to this one.
     * Equality is based on both `name` and current `value`.
     * <p>
     * Note: this may not be consistent with ordering, which compares by `name` only.
     *
     * @param otherObject the reference object with which to compare
     * @return `true` if this object is the same class and has equal `name` and `value`; otherwise `false`
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        City other = (City) otherObject;
        return name.equals(other.name) && this.country.equals(other.country);
    }

    /**
     * Returns a hash code value for the object, consistent with `equals`,
     * using both `name` and current `value`.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return 11 * this.name.hashCode() + 13 * this.country.getName().hashCode();
    }
}
