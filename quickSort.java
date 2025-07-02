package placement;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length - 1;
        QuickSort(arr, 0, n);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void QuickSort(int[] arr, int lb, int ub) {
        if (lb < ub) {
            int loc = partition(arr, lb, ub);
            QuickSort(arr, lb, loc - 1);
            QuickSort(arr, loc + 1, ub);
        }
    }

    public static int partition(int[] arr, int lb, int ub) {
        int pivot = arr[lb];
        int start = lb; // moving variables
        int end = ub;// ,,
        while (start < end) {
            while (start<=ub && arr[start] <= pivot) start++;   // the order in while condition is important since we must check are all elements
            while (arr[end] > pivot) end--;  // smaller or equal to pivot if yes then move out
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

            }
        }
        int temp = arr[lb];
        arr[lb] = arr[end];
        arr[end] = temp;
        return end;
    }

}

