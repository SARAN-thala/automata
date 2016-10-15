import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFA_Test {

    //power of 2
    @Test
    public void should_generate_dfa_for_string_whose_decimal_representation_is_power_of_two() throws Exception {
        Transition transitions = new Transition();
        transitions.set("q1", "1", "q2");
        transitions.set("q1", "0", "q1");
        transitions.set("q2", "1", "q3");
        transitions.set("q2", "0", "q2");
        transitions.set("q3", "1", "q3");
        transitions.set("q3", "0", "q3");

        ArrayList<String> states = new ArrayList<>(asList("q1", "q2", "q3")); // "q1":initial state "q2":final state "q3":dead state

        Alphabets alphabets = new Alphabets(new ArrayList<>(asList("1","0")));

        ArrayList<String> finalState = new ArrayList<>(asList("q2"));

        String initialState = "q1";
        Tuple tuple = new Tuple(alphabets, states, transitions, initialState, finalState);
        DFA dfa = new DFA(tuple);

        assertFalse(dfa.isLangPasses(new ArrayList<>(asList("a"))));
        assertTrue(dfa.isLangPasses(new ArrayList<>(asList("1"))));
        assertTrue(dfa.isLangPasses(new ArrayList<>(asList("1", "0"))));
        assertTrue(dfa.isLangPasses(new ArrayList<>(asList("1","0","0"))));
        assertTrue(dfa.isLangPasses(new ArrayList<>(asList("1","0","0","0"))));

        assertFalse(dfa.isLangPasses(new ArrayList<>(asList("0"))));
        assertFalse(dfa.isLangPasses(new ArrayList<>(asList("1","0","0","1"))));
        assertFalse(dfa.isLangPasses(new ArrayList<>(asList("0","1","1","1"))));
    }


    // begin with 1 and contain the string 001
    @Test
    public void should_generate_dfa_for_string_that_begin_with_one_and_contain_string_001() {
        Transition transitions = new Transition();
        transitions.set("q1", "1", "q2");
        transitions.set("q1", "0", "q6");
        transitions.set("q2", "1", "q2");
        transitions.set("q2", "0", "q3");
        transitions.set("q3", "1", "q3");
        transitions.set("q3", "0", "q4");
        transitions.set("q4", "1", "q5");
        transitions.set("q4", "0", "q4");
        transitions.set("q5", "1", "q5");
        transitions.set("q5", "0", "q5");
        transitions.set("q6", "1", "q6");
        transitions.set("q6", "0", "q6");

        ArrayList<String> states = new ArrayList<>(asList("q1", "q2", "q3", "q4", "q5", "q6")); // "q1":initial state "q5":final state "q6":dead state

        Alphabets alphabets = new Alphabets(new ArrayList<>(asList("0", "1")));

        String initialState = "q1";

        ArrayList<String> finalState = new ArrayList<>(asList("q5"));

        Tuple tuple = new Tuple(alphabets, states, transitions, initialState, finalState);
        DFA dfa = new DFA(tuple);

        assertTrue(dfa.isLangPasses(new ArrayList<>(asList("1", "0", "1", "0", "0", "1"))));
        assertTrue(dfa.isLangPasses(new ArrayList<>(asList("1", "0", "0", "1"))));
        assertFalse(dfa.isLangPasses(new ArrayList<>(asList("0", "0", "1"))));
    }


    // All pass other than "11" and "111"
    @Test
    public void should_generate_a_dfa_for_strings_other_than_string_11_and_111() throws Exception {
        Transition transitions = new Transition();
        transitions.set("q1", "1", "q2");
        transitions.set("q1", "0", "q5");
        transitions.set("q2", "1", "q3");
        transitions.set("q2", "0", "q5");
        transitions.set("q3", "1", "q4");
        transitions.set("q3", "0", "q5");
        transitions.set("q4", "1", "q5");
        transitions.set("q4", "0", "q5");
        transitions.set("q5", "1", "q5");
        transitions.set("q5", "0", "q5");

        ArrayList<String> states = new ArrayList<>(asList("q1", "q2", "q3", "q4", "q5"));// q1 initial state; q2 final state; q5 final state

        Alphabets alphabets = new Alphabets(new ArrayList<>(asList("0", "1")));

        String initialState = "q1";

        ArrayList<String> finalState = new ArrayList<>(asList("q2", "q5"));

        Tuple tuple = new Tuple(alphabets, states, transitions, initialState, finalState);
        DFA dfa = new DFA(tuple);

        assertFalse(dfa.isLangPasses(new ArrayList<>(asList("a"))));
        assertTrue(dfa.isLangPasses(new ArrayList<>(asList("1", "0", "0"))));
        assertFalse(dfa.isLangPasses(new ArrayList<>(asList("1", "1", "1"))));
    }
}