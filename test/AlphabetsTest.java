import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabetsTest {
    @Test
    public void return_false_when_given_an_invalid_string() throws Exception {
        Alphabets alphabets = new Alphabets("0,1");
        String[] input = {"x"};

        assertFalse(alphabets.isValidInput(input));
    }

    @Test
    public void return_true_when_given_a_valid_string() throws Exception {
        Alphabets alphabets = new Alphabets("0,1");
        String[] input = {"1"};

        assertTrue(alphabets.isValidInput(input));
    }

    @Test
    public void return_false_when_given_an_multiple_invalid_input() throws Exception {
        Alphabets alphabets = new Alphabets("0,1");
        String[] input = {"1","0","x"};

        assertFalse(alphabets.isValidInput(input));
    }
}