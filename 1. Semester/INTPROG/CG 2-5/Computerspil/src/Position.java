public class Position {
    private City from;
    private City to;
    private int distance;
    private int total;

    public Position(City from, City to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.total = distance;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public int getTotal() {
        return total;
    }

    public boolean move(){
        if(distance > 0){
            distance -= 1;
            return true;
        }
        return false;
    }

    public void turnAround(){
        City temp = from;
        from = to;
        to = temp;
        distance = total - distance;
    }

    public boolean hasArrived(){
        return distance == 0;
    }

    @Override
    public String toString() {
        return from.getName() + " (" + from.getValue() + ") -> " + to.getName() + " (" + to.getValue() + ") : " + distance + "/" + total;
    }

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

    @Override
    public int hashCode(){
        return 11 * this.from.hashCode() +
                13 * this.to.hashCode() +
                17 * this.distance +
                19 * this.total;
    }
}
