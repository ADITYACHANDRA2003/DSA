package placement;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class unionAndIntersection {

    public static void unionIntersection(int[] arr1, int[] arr2) {
        LinkedHashSet<Integer> unionSet = new LinkedHashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        HashSet<Integer> tempSet = new HashSet<>(); // For checking intersection
        int count1 = 0,count2 = 0;

        // Insert elements from arr1 into both union and tempSet
        for (int ele : arr1) {
            unionSet.add(ele);
            tempSet.add(ele);
        }

        // Process arr2: Add to union, check for intersection
        for (int ele : arr2) {
            unionSet.add(ele);
            if (tempSet.contains(ele)) {
                intersectionSet.add(ele);
            }
        }

        // Print Union
        System.out.println("The union is: " + unionSet.size()+ " " + unionSet);

        // Print Intersection
        System.out.println("The intersection is: " + intersectionSet.size() + " " + intersectionSet);
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        unionIntersection(arr1, arr2);
    }
}
