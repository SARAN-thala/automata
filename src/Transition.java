import java.util.HashMap;

class Transition {
    private HashMap<String, HashMap<String,String>> transition = new HashMap<>();

    void set(String currentState, String alphabet, String nextState) {
        transition.putIfAbsent(currentState, new HashMap<>());
        transition.get(currentState).put(alphabet, nextState);
    }

    String isNextState(String currentState, String alphabet) {

        return transition.get(currentState).get(alphabet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transition that = (Transition) o;

        return transition != null ? transition.equals(that.transition) : that.transition == null;

    }

    @Override
    public int hashCode() {
        return transition != null ? transition.hashCode() : 0;
    }
}
