package placement;

import java.util.Collections;
import java.util.Arrays;

public class chocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;  // rows and columns of chocolate squares
        Integer[] costVer = {2,1,3,1,4};  // Vertical cut costs
        Integer[] costHor = {4,1,2};      // Horizontal cut costs

        Arrays.sort(costVer, Collections.reverseOrder()); // Sort in descending order
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;  // Pointer for horizontal and vertical cuts
        int hp = 1, vp = 1; // Number of horizontal and vertical pieces
        int cost = 0;

        // Main loop to choose the most expensive cut first
        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] <= costVer[v]) {
                cost += costVer[v] * hp;  // Vertical cut increases horizontal pieces
                vp++;
                v++;
            } else {
                cost += costHor[h] * vp;  // Horizontal cut increases vertical pieces
                hp++;
                h++;
            }
        }

        // Add remaining vertical cuts
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            v++;
        }

        // Add remaining horizontal cuts
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            h++;
        }

        System.out.println("The minimum cost of cuts is: " + cost);
    }
}
