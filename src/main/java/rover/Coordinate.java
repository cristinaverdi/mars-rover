package rover;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void nextFrom(char direction) {
        switch(direction) {
            case 'N': y = y + 1; break;
            case 'S': y =  y - 1; break;
            case 'E': x = x + 1; break;
            case 'W': x = x -1; break;
            default: throw new IllegalArgumentException();
        }
    }

    public void reset() {
        x = 0;
        y = 0;
    }
}
