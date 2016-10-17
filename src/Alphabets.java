import java.util.ArrayList;

class Alphabets {

    private ArrayList<String> alphabets;

    public Alphabets(ArrayList<String> alphabets) {
        this.alphabets = alphabets;
    }

    boolean isValidInput(ArrayList<String> inputString) {
        boolean isValid = false;
        for (String s : inputString) {
            isValid = alphabets.contains(s);
            if (!isValid) {
                return isValid;
            }
        }
        return isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alphabets alphabets1 = (Alphabets) o;

        return alphabets != null ? alphabets.equals(alphabets1.alphabets) : alphabets1.alphabets == null;

    }

    @Override
    public int hashCode() {
        return alphabets != null ? alphabets.hashCode() : 0;
    }
}