package placement;
import java.util.ArrayList;

public class heapSort {
        // building max heap
        public static void heapify(int[] arr,int idx, int n){
            int left = idx * 2 + 1;  // left child of parent
            int right = idx * 2 + 2;  // right child of parent
            int maxIdx = idx; // parent


            if (left < n && arr[left] > arr[maxIdx]) {
                maxIdx = left;
            }
            if (right < n && arr[right] > arr[maxIdx]) {
                maxIdx = right;
            }

            if(maxIdx != idx) {
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[idx];
                arr[idx] = temp;

                heapify(arr,maxIdx,n);
            }
        }

        public static void hSort(int[] arr){
            int n = arr.length;

            // Step 1:- make a max heap
            for(int i = n/2 - 1; i >= 0; i--){ //Nodes beyond this index (from n/2 to 𝑛 − 1) are leaf nodes,
                heapify(arr,i,n);             // which are already heaps by definition
            }                            // (a single node satisfies the heap property).

            // Step 2:- push the largest element on the bottom
            for(int i = n - 1; i > 0; i--){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr,0,i);    // this will also decrease the size of the part of array in heapsort(think!)
                                         // everytime heapifying from first element to the last,secondlast,thirdlast
                                         // ...... 1
            }
    }

    public static void main(String[] args) {
       int[] arr = {5,3,8,1,4};
       hSort(arr);
       for(int i = 0; i < arr.length; i++){
           System.out.print(arr[i]+" ");
       }

    }
}
