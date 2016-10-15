import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class TransitionTest {
    @Test
    public void should_return_next_state_when_current_state_and_alphabet_provided() throws Exception {
        Transition transition = new Transition();
        transition.set("q1", "1", "q2");

        assertEquals("q2", transition.isNextState("q1", "1"));
        assertNotEquals("q1", transition.isNextState("q1", "1"));
        assertNotEquals("q2", transition.isNextState("q1", "2"));
    }

    @Test
    public void should_not_return_next_state_when_current_state_and_alphabet_are_wrong() throws Exception {
        Transition transition = new Transition();
        transition.set("q1", "0", "q1");

        assertNull(transition.isNextState("q1", "x"));
    }
}