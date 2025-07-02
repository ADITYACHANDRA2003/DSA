package placement;
import java.util.ArrayList;

public class heapOperations {
    public static class Heap {
        static ArrayList<Integer> arr = new ArrayList<>();

        public static void add(int data) { // O(logn)
            arr.add(data);
            int x = arr.size() - 1; // index of the newly added element
            int parent = (x - 1) / 2;

            // O(logn)
            while (x > 0 && arr.get(parent) > arr.get(x)) {  // check child node is not equal to root and parent>child
                // Swap parent and child to maintain heap property
                int temp = arr.get(parent);
                arr.set(parent, arr.get(x));   // set(index,value)
                arr.set(x, temp);

                // Move up the tree
                x = parent;
                parent = (x - 1) / 2;  // calculate new parent
            }
        }

        public static int peek(){  // The minimum element is the first element of the array or at index 0.
            return arr.get(0);
        }

        public static void heapify(int idx){
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int minIdx = idx; // parent

            // Now we are checking who is minimum between parent , left child and right child
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) { // left<arrsize is checking whether we are at
                minIdx = left;                                          // leaf node or not.
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            // agar minimum index ki value parent se change hoti hai
                if(minIdx != idx) {
                int temp = arr.get(minIdx);
                arr.set(minIdx, arr.get(idx));
                arr.set(idx, temp);

                heapify(minIdx);
            }
        }

        public static int remove(){

            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }

            int data = arr.get(0);
            //Step 1: Swap first and Last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2: delete the last element
            arr.remove(arr.size() - 1);

            // Step 3: Heapify
            heapify(0); // from root
            return data;
        }
    }

        public static void main(String[] args) {
            Heap.add(10);
            Heap.add(5);
            Heap.add(3);
            Heap.add(2);
            Heap.add(7);

            System.out.println("Heap after insertions: " + Heap.arr); // Min-heap representation
            System.out.println("Peek: " + Heap.peek());

            System.out.println("Removed: " + Heap.remove());
            System.out.println("Heap after removal: " + Heap.arr);

            System.out.println("Removed: " + Heap.remove());
            System.out.println("Heap after another removal: " + Heap.arr);
        }

}
