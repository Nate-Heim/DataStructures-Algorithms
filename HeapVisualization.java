import java.util.ArrayList;
import java.util.List;

public class HeapVisualization {

    static class MaxHeap {
        List<Character> heap;

        MaxHeap() {
            heap = new ArrayList<>();
        }

        void insert(char key) {
            heap.add(key);
            siftUp(heap.size() - 1);
            System.out.println("Added to heap: " + key);
        }

        char extractMax() {
            if (heap.isEmpty())
                throw new IllegalStateException("Heap is empty");

            char max = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            if (!heap.isEmpty())
                siftDown(0);
            return max;
        }

        void siftUp(int index) {
            int parentIndex = (index - 1) / 2;
            while (index > 0 && heap.get(parentIndex) < heap.get(index)) {
                swap(parentIndex, index);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }

        void siftDown(int index) {
            int maxIndex = index;
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(maxIndex))
                maxIndex = leftChildIndex;

            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex))
                maxIndex = rightChildIndex;

            if (index != maxIndex) {
                swap(index, maxIndex);
                siftDown(maxIndex);
            }
        }

        void swap(int i, int j) {
            char temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        boolean isEmpty() {
            return heap.isEmpty();
        }

        String printHeap() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (char ch : heap) {
                sb.append(ch).append(", ");
            }
            if (!heap.isEmpty()) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        char[] operations = {'P', 'R', 'I', 'O', '*', 'R', '*', '*', 'I', '*', 'T', '*', 'Y', '*', '*', '*', 'Q', 'U', 'E', '*', '*', 'U', '*', 'E'};

        System.out.println("Sequence of Heaps:");
        for (char operation : operations) {
            if (operation == '*') {
                if (!heap.isEmpty()) {
                    char removed = heap.extractMax();
                    System.out.println("Removed from heap: " + removed);
                }
            } else {
                heap.insert(operation);
            }
            System.out.println(heap.printHeap());
        }
    }
}