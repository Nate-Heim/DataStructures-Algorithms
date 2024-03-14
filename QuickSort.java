import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort {

    static class ExchangeCounter implements Comparable<ExchangeCounter> {
        int value;
        int numberOfExchanges = 0;

        ExchangeCounter(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(ExchangeCounter other) {
            return Integer.compare(this.value, other.value);
        }
    }

    static int totalExchanges = 0; // Counter to accumulate total exchanges

    static void quickSort(List<ExchangeCounter> list) {
        quickSort(list, 0, list.size() - 1);
    }

    static void quickSort(List<ExchangeCounter> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);
            quickSort(list, low, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, high);
        }
    }

    static int partition(List<ExchangeCounter> list, int low, int high) {
        ExchangeCounter pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                Collections.swap(list, i, j);
                list.get(j).numberOfExchanges++; // Increment exchange counter
                totalExchanges++; // Increment total exchanges
            }
        }
        Collections.swap(list, i + 1, high);
        list.get(high).numberOfExchanges++; // Increment exchange counter
        totalExchanges++; // Increment total exchanges
        return i + 1;
    }

    static boolean nextPermutation(List<ExchangeCounter> list) {
        int i = list.size() - 2;
        while (i >= 0 && list.get(i).value >= list.get(i + 1).value) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = list.size() - 1;
        while (list.get(j).value <= list.get(i).value) {
            j--;
        }
        Collections.swap(list, i, j);
        Collections.reverse(list.subList(i + 1, list.size()));
        return true;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java QuickSort <number_of_elements> [<min_value> <max_value>]");
            return;
        }

        int numElements = Integer.parseInt(args[0]);
        int minValue = 0;
        int maxValue = 100;

        if (args.length >= 3) {
            minValue = Integer.parseInt(args[1]);
            maxValue = Integer.parseInt(args[2]);
        }

        List<ExchangeCounter> values = new ArrayList<>();
        Random random = new Random();

        // Generate random numbers
        for (int i = 0; i < numElements; i++) {
            int randomValue = random.nextInt(maxValue - minValue + 1) + minValue;
            values.add(new ExchangeCounter(randomValue));
        }

        System.out.println("Original array:");
        for (ExchangeCounter item : values) {
            System.out.print(item.value + " ");
        }
        System.out.println();

        quickSort(values);

        System.out.println("Sorted array:");
        for (ExchangeCounter item : values) {
            System.out.print(item.value + " ");
        }
        System.out.println();

        // Print the number of exchanges for each element
        System.out.println("Number of exchanges for each element:");
        for (ExchangeCounter item : values) {
            System.out.println("Value: " + item.value + ", Exchanges: " + item.numberOfExchanges);
        }

        // Print the total number of exchanges possible
        System.out.println("Total number of exchanges possible: " + totalExchanges);
    }
}