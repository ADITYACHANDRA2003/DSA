package placement;

import java.util.HashSet;

public class countDistinctElement {

    public static void countDistinct(int[] arr){
        HashSet<Integer> hm = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hm.add(arr[i]);
        }
        System.out.println("The no. of distinct Elements is: " + hm.size());
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,5,6,7,3,4,2,1};
        countDistinct(nums);
    }
}
