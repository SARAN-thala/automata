import java.util.ArrayList;

class DFA {

    private Tuple tuple;

    public DFA(Tuple tuple) {
        this.tuple = tuple;
    }

    boolean isLangPasses(ArrayList<String> inputAlphabets) {
        return tuple.isValidAlphabet(inputAlphabets) && tuple.isProcessableAlphabet(inputAlphabets);
    }
}
