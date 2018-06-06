package rover;

import org.junit.Test;
import org.junit.Before;
import junitparams.Parameters;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class RoverShould {

    private Rover rover;

    @Before public void
    set_up() {
        rover = new Rover();
        rover.initPosition(0, 0, 'N');
    }

    @Test
    @Parameters({
        "R, 0:0:E",
        "RR, 0:0:S",
        "RRR, 0:0:W",
        "RRRR, 0:0:N"
    })
    public void
    turn_right_when_command_is_R(String commands, String position) {
        assertThat(rover.run(commands), is(position));
    }


    @Test
    @Parameters({
        "L, 0:0:W",
        "LL, 0:0:S",
        "LLL, 0:0:E",
        "LLLL, 0:0:N"
    })
    public void
    turn_left_when_command_is_L(String commands, String position) {
        assertThat(rover.run(commands), is(position));
    }

    @Test
    @Parameters({
            "M, 0:1:N",
            "MM, 0:2:N",
            "RM, 1:0:E",
            "MLLM, 0:0:S",
            "RMMLM, 2:1:N",
            "RMLLM, 0:0:W"
    })
    public void
    move_forward_when_command_is_M(String commands, String position) {
        assertThat(rover.run(commands), is(position));
    }

    @Test
    @Parameters({
        "LM, 0:0:W",
        "RRM, 0:0:S",
        "MMMMMMMMMM, 0:10:N",
        "RMMMMMMMMMM, 10:0:E",
        "MMMMMMMMMMM, 0:0:N",
        "RMMMMMMMMMMM, 0:0:E",
        "MMMMMMMMMMMM, 0:1:N",
        "MMMMMMMMMMMMM, 0:2:N"
    })
    public void
    wrap_around_when_at_the_end_of_the_grid(String commands, String position) {
        assertThat(rover.run(commands), is(position));
    }

    @Test
    @Parameters({
        "M, 0:0:N",
        "RM, 1:0:E",
        "RML, 1:0:N",
        "RMLM, 1:0:N"
    })
    public void report_obstacle_and_return_to_last_possible_position_when_bump_into(String commands, String position) {
        assertThat(rover.run(commands), is(position));
    }
}
