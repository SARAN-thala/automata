import java.util.ArrayList;

class Tuple {
    private final Alphabets alphabets;
    private final ArrayList<String> states;
    private final Transition transitions;
    private final String initialState;
    private final ArrayList<String> finalState;

    Tuple(Alphabets alphabets, ArrayList<String> states, Transition transitions, String initialState, ArrayList<String> finalState) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    boolean isValidAlphabet(ArrayList<String> inputAlphabet) {
        return alphabets.isValidInput(inputAlphabet);
    }

    boolean isProcessableAlphabet(ArrayList<String> inputAlphabets) {
        String currentState = initialState;
        for (String input : inputAlphabets) {
            currentState = transitions.isNextState(currentState, input);
        }
        return finalState.contains(currentState);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        if (alphabets != null ? !alphabets.equals(tuple.alphabets) : tuple.alphabets != null) return false;
        if (states != null ? !states.equals(tuple.states) : tuple.states != null) return false;
        if (transitions != null ? !transitions.equals(tuple.transitions) : tuple.transitions != null) return false;
        if (initialState != null ? !initialState.equals(tuple.initialState) : tuple.initialState != null) return false;
        return finalState != null ? finalState.equals(tuple.finalState) : tuple.finalState == null;

    }

    @Override
    public int hashCode() {
        int result = alphabets != null ? alphabets.hashCode() : 0;
        result = 31 * result + (states != null ? states.hashCode() : 0);
        result = 31 * result + (transitions != null ? transitions.hashCode() : 0);
        result = 31 * result + (initialState != null ? initialState.hashCode() : 0);
        result = 31 * result + (finalState != null ? finalState.hashCode() : 0);
        return result;
    }
}
