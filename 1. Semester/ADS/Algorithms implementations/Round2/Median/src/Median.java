// Version: 20200917
// Handin done by:
//   AU786751 Martin Due
//   AU806016 Filip Raeburn
//   AU804976 Matthias W. Jensen
// Contributions:
//   Teoretisk snak og diskussion af opgaven udført af alle medlemmer.
//   Implementering udført af Martin Due & Matthias W. Jensen.

import java.io.*;
import java.util.*;

public class Median {
    // Max-heap for the lower half, min-heap for the upper half
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // lower half
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // upper half

    public void add(int x) {
        // If maxHeap is empty or x is <= the largest element of the lower half,
        // put x into maxHeap (lower half). Otherwise put x into minHeap (upper half).
        if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
            maxHeap.add(x);
        } else {
            minHeap.add(x);
        }
        // Rebalance so sizes differ by at most 1: move the root from the larger heap to the smaller heap when necessary.
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public int median() {
        // If no elements present, throw exception
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            throw new NoSuchElementException("No elements present");
        }
        // If equal size, return the upper median (element at index N/2) for even N.
        if (maxHeap.size() == minHeap.size()) {
            return minHeap.peek();
        }
        // Return root of the larger heap; that root is the median for odd N.
        return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : minHeap.peek();
    }
}
