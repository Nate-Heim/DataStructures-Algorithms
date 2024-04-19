import java.io.IOException;

public class Outcast {
    private WordNet wn; // declare the wn variable here

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        // initialize
        wn = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        int outcast_id = -999;

        return nouns[outcast_id];
    }

    // Unit Test client
    public static void main(String[] args) throws IOException { //throw because WordNet throws
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}