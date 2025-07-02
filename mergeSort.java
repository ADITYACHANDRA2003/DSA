package placement;

public class mergeSort {
    public static void main(String[] args){
        int[] arr = {6,3,9,5,2,8};
        int n = arr.length-1;
        MergeSort(arr, 0, n);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void MergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid + 1, end);
            Merge(arr, start, mid, end);
        }
    }

    public static void Merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[end - start + 1];

        // Merging both halves
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copying remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copying remaining elements from right half
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copying sorted elements back to original array
        for (i = 0, j = start; i < temp.length; i++, j++) {
            arr[j] = temp[i];
        }
    }
}
