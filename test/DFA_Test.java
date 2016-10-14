import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
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

        String[] states = new String[3];
        states[0] = "q1"; //initial state
        states[1] = "q2"; //final state
        states[2] = "q3"; //dead state

        Alphabets alphabets = new Alphabets("0,1");

        String[] finalState = new String[1];
        finalState[0] = "q2";

        String initialState = new String("q1");

        DFA dfa = new DFA(alphabets, states, transitions, initialState, finalState );

        assertEquals(false, dfa.isLangPasses("a"));
        assertEquals(true, dfa.isLangPasses("1"));
        assertEquals(true, dfa.isLangPasses("10"));
        assertEquals(true, dfa.isLangPasses("100"));
        assertEquals(true, dfa.isLangPasses("1000"));

        assertEquals(false, dfa.isLangPasses("0"));
        assertEquals(false, dfa.isLangPasses("1001"));
        assertEquals(false, dfa.isLangPasses("0111"));
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

        String[] states = new String[6];
        states[0] = "q1"; //initial state
        states[1] = "q2";
        states[2] = "q3";
        states[3] = "q4";
        states[4] = "q5"; //final state
        states[5] = "q6"; //dead state

        Alphabets alphabets = new Alphabets("0,1");

        String initialState = "q1";

        String[] finalState = new String[1];
        finalState[0] = "q5";

        DFA dfa = new DFA(alphabets, states, transitions, initialState, finalState );

        assertEquals(true, dfa.isLangPasses("101001"));
        assertEquals(true, dfa.isLangPasses("1001"));
        assertEquals(false, dfa.isLangPasses("001"));
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

        String[] states = new String[6];
        states[0] = "q1"; //initial state
        states[1] = "q2"; //final state
        states[2] = "q3";
        states[3] = "q4";
        states[4] = "q5"; //final state

        Alphabets alphabets = new Alphabets("0,1");

        String initialState = "q1";

        String[] finalState = new String[2];
        finalState[0] = "q2";
        finalState[1] = "q5";

        DFA dfa = new DFA(alphabets, states, transitions, initialState, finalState );

        assertEquals(false, dfa.isLangPasses("a"));
        assertEquals(true, dfa.isLangPasses("100"));
        assertEquals(false, dfa.isLangPasses("111"));
    }

}