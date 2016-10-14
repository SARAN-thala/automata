import java.util.ArrayList;

public class Alphabets {

    private String alphabets;

    public Alphabets(String alphabets) {
        this.alphabets = alphabets;
    }

    public boolean isValidInput(String[] inputString) {
        boolean isValid = false;
        for (String s: inputString) {
            isValid = alphabets.contains(s);
        }
        return isValid;
    }
}
