package placement;

import java.util.HashMap;

public class subarraySumEqualsK {

    /**
     * This method counts the number of subarrays whose sum equals k.
     *
     * @param arr The input array of integers
     * @param k   The target sum
     * @return The count of subarrays whose sum equals k
     */
    public static int countSubarraysWithSumK(int[] arr, int k) {
        // HashMap to store the prefix sum and its frequency
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: Initialize prefix sum of 0 with frequency 1
        // This helps in cases where a subarray starting from index 0 sums to k
        prefixSumMap.put(0, 1);

        int sum = 0;  // Variable to keep track of the cumulative sum
        int count = 0; // Variable to count the number of valid subarrays

        // Traverse through the array
        for (int num : arr) {
            sum += num; // Add the current element to the cumulative sum

            // Check if (sum - k) exists in the HashMap
            // If yes, it means there exists a subarray ending at the current index that sums to k
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k); // Add its frequency to the count
            }

            // Store the cumulative sum in the HashMap or update its frequency
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count; // Return the total count of subarrays with sum k
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10; // Target sum

        // Call the method and print the result
        System.out.println("The number of subarrays with sum " + k + " = " + countSubarraysWithSumK(arr, k));
    }
}
