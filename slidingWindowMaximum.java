package placement;

import java.util.PriorityQueue;

public class slidingWindowMaximum {
    public static class Info implements Comparable<Info> {
        int val;
        int idx;

        Info(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info o) {
            return o.val - this.val; // Max-Heap (descending order)
        }
    }

    public static void maxWindowVal(int[] arr, int windowSize) {
        PriorityQueue<Info> pq = new PriorityQueue<>();

        // Process first window
        for (int i = 0; i < windowSize; i++) {
            pq.add(new Info(arr[i], i));
        }

        // Print maximum for first window
        System.out.print(pq.peek().val + " ");  // since in reversed priority queue max element at first so the max
                                                // the maximum element that belongs to window will be at the first

        // Process remaining windows,ab first window ke baad wale elements ko process karenge
        for (int i = windowSize; i < arr.length; i++) {
            pq.add(new Info(arr[i], i));

            // Remove elements which are out of the current window
            while (pq.peek().idx <= i - windowSize) { //This condition ensures that we remove elements
                pq.poll();                           //from the heap that are outside the current sliding window.
            }
            // to be a element of window its index must have the value > current window's starting index - windowsize

            // Print current window maximum
            System.out.print(pq.peek().val + " ");
        }
    }

    public static void main(String[] args) {
        int[] val = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxWindowVal(val, k);
    }
}
