import java.util.HashMap;

public class Transition {
    private HashMap<String, HashMap<String,String>> transition = new HashMap<>();

    public void set(String currentState, String alphabet, String nextState) {
        transition.putIfAbsent(currentState, new HashMap<>());
        transition.get(currentState).put(alphabet, nextState);
    }

    public String isNextState(String currentState, String alphabet) {
        return transition.get(currentState).get(alphabet);
    }
}