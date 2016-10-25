import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class AlphabetsTest {
    @Test
    public void return_false_when_given_an_invalid_string() throws Exception {
        ArrayList<String> strings = new ArrayList<>(asList("1", "0"));
        Alphabets alphabets = new Alphabets(strings);
        ArrayList<String> input = new ArrayList<String>(asList("x"));

        assertFalse(alphabets.isValidInput(input));
    }

    @Test
    public void return_true_when_given_a_valid_string() throws Exception {
        ArrayList<String> strings = new ArrayList<>(asList("1", "0"));
        Alphabets alphabets = new Alphabets(strings);
        ArrayList<String> input = new ArrayList<String>(asList("1"));

        assertTrue(alphabets.isValidInput(input));
    }

    @Test
    public void return_false_when_given_an_multiple_invalid_input() throws Exception {
        ArrayList<String> strings = new ArrayList<>(asList("1", "0"));
        Alphabets alphabets = new Alphabets(strings);
        ArrayList<String> input = new ArrayList<String>(asList("1", "x", "0"));
        ArrayList<String> input2 = new ArrayList<String>(asList("1", "0", "0"));

        assertFalse(alphabets.isValidInput(input));
        assertTrue(alphabets.isValidInput(input2));
    }
}

