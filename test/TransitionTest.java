import org.junit.Test;

import static org.junit.Assert.*;

public class TransitionTest {
    @Test
    public void should_return_next_state_when_current_state_and_alphabet_provided() throws Exception {
        Transition transition = new Transition();
        transition.set("q1", "1", "q2");

        assertEquals("q2", transition.isNextState("q1", "1"));
    }

    @Test
    public void should_not_return_next_state_when_current_state_and_alphabet_are_wrong() throws Exception {
        Transition transition = new Transition();
        transition.set("q1", "0", "q1");

        assertEquals(null, transition.isNextState("q1", "x"));
    }

}