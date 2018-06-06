package rover;

import java.util.InputMismatchException;

public class Direction {
    private char value;

    Direction(char value) {
        this.value = value;
    }
    void rotateInClockWiseFrom(char direction) {
        switch (direction) {
            case 'N': value = 'E'; break;
            case 'E': value = 'S'; break;
            case 'S': value = 'W'; break;
            case 'W': value = 'N'; break;

            default:
                throw new InputMismatchException();
        }
    }

     void rotateAgainstClockFrom(char direction) {
        switch (direction) {
            case 'N': value = 'W'; break;
            case 'W': value = 'S'; break;
            case 'S': value = 'E'; break;
            case 'E': value = 'N'; break;
            default:
                throw new InputMismatchException();
        }
    }

    char value() {
        return value;
    }
}