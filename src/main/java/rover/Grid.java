package rover;

import java.util.Arrays;
import java.util.List;

public class Grid {
    private List<String> obstacles;
    private int length;
    private int height;
    private int origin;

    public Grid() {
        length = 10;
        height = 10;
        origin = 0;

        obstacles = Arrays.asList("0:1:N", "1:1:N");
    }

    public boolean isPositionWithin(Position position) {
        Coordinate coordinate = position.coordinate();
        return !(coordinate.y() > length ||
                coordinate.x() > height ||
                coordinate.y() < origin ||
                coordinate.x() < origin);
    }

    public boolean isObstacle(Position position) {
        for(String obstacle : obstacles) {
            if(position.format().value().equals(obstacle)) {
                return true;
            }
        }

        return false;
    }
}
