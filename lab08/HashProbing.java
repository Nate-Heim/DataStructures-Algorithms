import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class HashProbing {

    public static double calculateAverageCost(int N, Random random) {
        int probes = 0;

        // Create boolean array for hash table simulation
        boolean[] A = new boolean[2 * N];

        // Insert N random keys using linear probing
        for (int i = 0; i < N; i++) {
            int key = random.nextInt();
            int index = (key % (2 * N) + (2 * N)) % (2 * N);

            // Handle collision using linear probing
            while (A[index]) {
                index = (index + 1) % (2 * N);
            }
            A[index] = true;
        }

        // Calculate average cost for 10,000 search misses
        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt();
            int index = (key % (2 * N) + (2 * N)) % (2 * N);
            int counter = 1; //set to 1 to account for the initial probe

            // Probe until empty cell is found
            while (A[index] && counter < 2 * N) {
                index = (index + 1) % (2 * N);
                counter++;
            }
            probes += counter;
        }

        return (double) probes / 10000;
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int N = 10; N <= 100000000; N *= 10) {
            double mean = calculateAverageCost(N, random); // Call the function to calculate average cost
            StdOut.println("Average probes for a miss with N=" + N + " is: " + mean);
        }
    }
}