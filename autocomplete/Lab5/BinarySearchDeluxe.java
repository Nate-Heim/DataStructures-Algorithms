import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that equals the search key, or -1
    // if no such key. (lets hope it doesnt become no such key :P)
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException("null argument");
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(a[mid], key) < 0)
                lo = mid + 1;
            else if (comparator.compare(a[mid], key) > 0)
                hi = mid - 1;
            else if (mid > 0 && comparator.compare(a[mid - 1], key) == 0)
                hi = mid - 1;
            else
                return mid;
        }
        return -1;

    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if
    // no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException("null argument");
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(a[mid], key) < 0)
                lo = mid + 1;
            else if (comparator.compare(a[mid], key) > 0)
                hi = mid - 1;
            else if (mid < a.length - 1 && comparator.compare(a[mid + 1], key) == 0)
                lo = mid + 1;
            else
                return mid;
        }
        return -1; // FIXME
    }
    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
    
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        Arrays.sort(terms);
        
        Term searchme = new Term("J",0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("A: " + first + " to " + last);
       
        searchme = new Term("E",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);
        
        searchme = new Term("T",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);        
    }
}