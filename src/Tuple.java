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
}
