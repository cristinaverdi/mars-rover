package rover;

public class Rover {
    private Grid grid;
    private Position position;

    Rover() {
        this.grid = new Grid();
    }

    void initPosition(int coordinateX, int coordinateY, char direction) {
        position = new Position( coordinateX, coordinateY, direction);
    }

    String run(String commands) {
        Position next = savePreviousAndGetNextPosition(commands);
        return next.format().value();
    }

    private Position savePreviousAndGetNextPosition(String commands) {
        for(char command : commands.toCharArray()) {
            position.previous(position);
            performCommand(command);
        }
        return position;
    }

    private void performCommand(char command) {
        if(command == 'R') {
            turnRight();
        }else if(command == 'L') {
            turnLeft();
        }else if( command == 'M') {
            move();
        }
    }

    private void turnLeft() {
        position.atLeft();
    }

    private void turnRight() {
        position.atRight();
    }

    private void move() {
        position.nextCoordinate();

        if(isOutOfGridBoundaries()) {
            position.reset();
        }

        if(hasBumpedIntoObstacle()) {
            position = position.previous();
        }
    }

    private boolean hasBumpedIntoObstacle() {
        return grid.isObstacle(position);
    }

    private boolean isOutOfGridBoundaries() {
        return  !grid.isPositionWithin(position);
    }
}
