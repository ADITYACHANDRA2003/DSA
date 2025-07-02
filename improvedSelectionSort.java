package placement;


// This code only sort and checks whether the array is sorted or not if it is it will only give message enot do any action
public class improvedSelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        boolean isSorted = true; // Assume array is sorted initially

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                if (arr[j] < arr[j - 1]) {
                    isSorted = false; // Detected unsorted condition
                }
            }

            // Swap if a new minimum was found
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        // Check if the array was already sorted
        if (isSorted) {
            System.out.println("The array was already sorted.");
        }

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Already sorted array
        selectionSort(arr);
    }
}
