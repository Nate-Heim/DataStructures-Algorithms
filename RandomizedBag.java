import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedBag<Item> implements Iterable<Item> {

    private Item[] items;   // Bag items
    private int N;          // Number of items in the bag
    private Random random;  // Random number generator

    public RandomizedBag() {
        items = (Item[]) new Object[2]; // Initial capacity of 2
        N = 0;
        random = new Random();
    }

    // Resizes the bag if the capacity is full
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (N == items.length) {
            resize(2 * items.length); // Double the capacity when full
        }
        items[N++] = item;
    }

    public Item get() {
        if (isEmpty()) {
            throw new NoSuchElementException("Bag is empty");
        }
        int randomIndex = random.nextInt(N); // Choose a random index
        Item item = items[randomIndex];
        items[randomIndex] = items[N - 1]; // Swap the chosen item with the last one
        N--;
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Bag is empty");
        }
        int randomIndex = random.nextInt(N);
        return items[randomIndex];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator(); // Create an independent iterator
    }

    // Private iterator class for randomized order
    private class RandomBagIterator implements Iterator<Item> {
        private int i = 0;   // Index of the next item
        private int[] shuffled; // Shuffled copy of the items for this iterator

        public RandomBagIterator() {
            shuffled = new int[N]; // Allocate space for shuffled indices
            for (int j = 0; j < N; j++) {
                shuffled[j] = j; // Copy indices
            }
            // Shuffle the indices using Fisher-Yates shuffle
            for (int j = N - 1; j > 0; j--) {
                int swapIndex = random.nextInt(j + 1);
                int temp = shuffled[j];
                shuffled[j] = shuffled[swapIndex];
                shuffled[swapIndex] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items");
            }
            return items[shuffled[i++]]; // Return item based on shuffled index
        }
    }

    public static void main(String[] args) {
        RandomizedBag<String> bag = new RandomizedBag<>();
        bag.put("we");
        bag.put("are");
        bag.put("the");
        bag.put("music-makers");
        bag.put("and");
        bag.put("dreamers");
        bag.put("of");
        bag.put("dreams");

        System.out.println("Original bag:");
        for (String item : bag) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Simulate removing one element in random order
        String removedItem = bag.get();
        System.out.println("Removed item: " + removedItem);

        System.out.println("Remaining bag:");
        for (String item : bag) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}