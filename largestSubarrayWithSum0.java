package placement;

import java.util.HashMap;

public class largestSubarrayWithSum0 {

    public static void largestSubarray(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0; // Should start from 0 instead of Integer.MIN_VALUE

        for(int j = 0; j < arr.length; j++){
            sum += arr[j];

            // Case 1: If sum becomes 0, then the subarray from index 0 to j is the longest
            if (sum == 0) {
                max = j + 1;
            }

            // Case 2: If this sum has been seen before, calculate subarray length
            if (map.containsKey(sum)) {
                max = Math.max(max, j - map.get(sum));
            } else {
                // Store the first occurrence of this sum
                map.put(sum, j);
            }
        }

        System.out.println("The length of the largest subarray with sum zero = " + max);
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10}; // Expected output: 5
        largestSubarray(arr);
    }
}
