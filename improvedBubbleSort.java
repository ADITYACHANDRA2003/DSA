package placement;

public class improvedBubbleSort {
    // O(n^2) and omega(n) !!

    public static void bubbleSort(int[] nums){
        int n = nums.length, temp;
        boolean alreadySorted;
        for (int i = 0; i < n-1; i++) {
            alreadySorted = true; // Track if the array is already sorted at the start
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    alreadySorted = false; // Array wasn't already sorted
                }
            }
            if (alreadySorted) {
                break; // Exit early if no swaps were made
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,7,3,45,57,67,74,32,2,35,56,655,54,3,32}; // Input array
        bubbleSort(nums);
    }
}
