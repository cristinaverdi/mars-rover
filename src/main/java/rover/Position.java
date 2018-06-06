package rover;

public class Position {

    private String value;
    private Position previous;
    private Direction direction;
    private Coordinate coordinate;

    public Position(int coordinateX, int coordinateY, char direction) {

        this.direction = new Direction(direction);
        this.coordinate  = new Coordinate(coordinateX, coordinateY);
    }

    public Position format() {
        this.value = coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
        return this;
    }

    public String value() {
        if(value != null) {
            return value;
        }

        format();
        return value;
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    public Position nextCoordinate() {
        coordinate.nextFrom(direction.value());
        return this;
    }

    public void reset() {
        coordinate.reset();
    }

    public Position previous() {
        return previous;
    }

    public void atLeft() {
        direction.rotateAgainstClockFrom(direction.value());
    }

    public void atRight() {
        direction.rotateInClockWiseFrom(direction.value());
    }

    public void previous(Position current) {
        previous = new Position(current.coordinate().x(), current.coordinate().y(), current.direction.value());
    }
}
