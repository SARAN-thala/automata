import java.util.ArrayList;

class DFA {

    private Tuple tuple;

    public DFA(Tuple tuple) {
        this.tuple = tuple;
    }

    boolean isLangPasses(ArrayList<String> inputAlphabets) {
        return tuple.isValidAlphabet(inputAlphabets) && tuple.isProcessableAlphabet(inputAlphabets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DFA dfa = (DFA) o;

        return tuple != null ? tuple.equals(dfa.tuple) : dfa.tuple == null;

    }

    @Override
    public int hashCode() {
        return tuple != null ? tuple.hashCode() : 0;
    }

}
