import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TupleTest {
    private Transition transitions;
    private ArrayList<String> states;
    private Alphabets alphabets;
    private ArrayList<String> finalState;
    private String initialState;

    @Before
    public void setUp() throws Exception {
        initialState = "q1";

        alphabets = new Alphabets(new ArrayList<>(asList("0", "1")));

        transitions = new Transition();
        transitions.set("q1", "1", "q2");
        transitions.set("q1", "0", "q1");
        transitions.set("q2", "1", "q3");
        transitions.set("q2", "0", "q2");
        transitions.set("q3", "1", "q3");
        transitions.set("q3", "0", "q3");

        states = new ArrayList<>(asList("q1","q2","q3"));

        finalState = new ArrayList<>(asList("q2"));
    }

    @Test
    public void should_check_when_is_valid_alphabet() throws Exception {
        Tuple tuple = new Tuple(alphabets, states, transitions, initialState, finalState);
        assertTrue(tuple.isValidAlphabet(new ArrayList<>(asList("1", "0"))));
        assertFalse(tuple.isValidAlphabet(new ArrayList<>(asList("1", "2"))));
    }

    @Test
    public void should_check_wheather_is_processable_alphabet_or_not() throws Exception {
        Tuple tuple = new Tuple(alphabets, states, transitions, initialState, finalState);
        assertTrue(tuple.isProcessableAlphabet(new ArrayList<>(Collections.singletonList("1"))));
        assertTrue(tuple.isProcessableAlphabet(new ArrayList<>(asList("1", "0"))));
        assertFalse(tuple.isProcessableAlphabet(new ArrayList<>(asList("1", "0", "1"))));
    }
}