import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]); // Read k from the command line

        RandomizedBag<String> bag = new RandomizedBag<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.put(item);
        }

        if (k < 0 || k > bag.size()) {
            throw new IllegalArgumentException("k must be between 0 and the number of items");
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(bag.get()); // Print k random items
        }
    }
}