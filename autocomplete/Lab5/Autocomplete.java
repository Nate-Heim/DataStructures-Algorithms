import java.util.Arrays;
import java.util.Comparator;
public class Autocomplete {
/*
Trying to create an autocomplete as a project, while
it is a good program in and of itself its just a tool
so it isn't useful outside of something utilizing it.
 */
    private Term[] terms;
}

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        this.terms = terms;
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        Term[] matches = new Term[0];
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].query.startsWith(prefix)) {
                matches = Arrays.copyOf(matches, matches.length + 1);
                matches[matches.length - 1] = terms[i];
            }
        }
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        int count = 0;
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].query.startsWith(prefix)) {
                count++;
            }
        }
        return count;
    }

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        
        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}