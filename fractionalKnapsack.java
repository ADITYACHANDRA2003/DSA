package placement;

import java.util.Arrays;

public class fractionalKnapsack {

    public static void maxProfit(int[] values, int[] weights, int capacity) {
        int n = values.length;
        double[][] items = new double[n][3]; // Store value, weight, and ratio

        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];    // Value
            items[i][1] = weights[i];   // Weight
            items[i][2] = (double) values[i] / weights[i]; // Value-to-weight ratio
        }

        // Sort items in descending order of value/weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));

        double maxProfit = 0.0;

        for (int i = 0; i < n; i++) {
            if (capacity >= items[i][1]) {
                // Take the full item
                maxProfit += items[i][0];
                capacity -= items[i][1];
            } else {
                // Take fraction of the item
                maxProfit += items[i][2] * capacity;
                break; // Knapsack is full
            }
        }

        System.out.println("The max profit is: " + maxProfit);
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        maxProfit(values, weights, capacity);
    }
}
