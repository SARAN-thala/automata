import java.util.ArrayList;
import java.util.Arrays;

public class DFA {

    private final Alphabets alphabets;
    private final String[] states;
    private final Transition transitions;
    private final String initialState;
    private final String[] finalState;
    private String currentState;

    public DFA(Alphabets alphabets, String[] states, Transition transitions, String initialState, String[] finalState) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
        this.currentState = null;
    }

//    public boolean isLanguagePasses() {
//        if (this.alphabets.isEmpty()) {
//            return false;
//        }
//        for (int i = 0; i < alphabets.size(); i++) {
//            if (currentState == null)
//                this.currentState = this.getNextState(initialState, alphabets.get(i), transitions);
//            this.currentState = this.getNextState(initialState, alphabets.get(i), transitions);
//        }
//
//        if (currentState == this.finalState)
//            return true;
//        return false;
//    }
//
//    private String getNextState(String currentState, String alphabet, ArrayList<Transition> transitions) {
//        for (Transition transition : transitions) {
//            if (transition.isNextState(currentState, alphabet)) {
//                currentState = transition.getNextState();
//                return currentState;
//            }
//        }
//        return currentState;
//    }

    public boolean isLangPasses(String input) {
        String[] alphabet = input.split("");
        if (!alphabets.isValidInput(alphabet))
            return false;
        String currentState = initialState;
        for (String inputs : alphabet) {
            currentState = transitions.isNextState(currentState,inputs);
        }
        return Arrays.asList(finalState).contains(currentState);
    }
}
