import java.util.ArrayList;

class Alphabets {

    private ArrayList<String> alphabets;

    public Alphabets(ArrayList<String> alphabets) {
        this.alphabets = alphabets;
    }

    boolean isValidInput(ArrayList<String> inputString) {
        boolean isValid = false;
        for (String s: inputString) {
            isValid = alphabets.contains(s);
            if(!isValid){
                return isValid;
            }
        }
        return isValid;
    }
}