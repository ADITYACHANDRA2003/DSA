package placement;

import java.util.*;

public class containerWithMostWater2PointerApproach {

//    O(n^2)
//    public static void maxWTr(ArrayList<Integer> height){
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<height.size();i++){
//            for(int j=i+1;j<height.size();j++){
//                int len = length(i,j);
//                int width = Math.min(height.get(i),height.get(j));
//                max = Math.max(max,width*len);
//            }
//        }
//        System.out.println(max);
//    }

    //O(n)  2 - POINTER APPROACH
        public static void maxWTr(ArrayList<Integer> height) {
            int leftPointer = 0, rightPointer = height.size() - 1;
            int max = 0;  // Use 0 instead of Integer.MIN_VALUE because area cannot be negative

            while (leftPointer < rightPointer) {
                int len = rightPointer - leftPointer;
                int width = Math.min(height.get(leftPointer), height.get(rightPointer));
                max = Math.max(max, width * len);  // Calculate area before moving pointers

                // Move the pointer pointing to the smaller height
                if (height.get(leftPointer) < height.get(rightPointer)) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
            System.out.println(max);
        }

    public static void main(String[] args) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(1);
      list.add(8);
      list.add(6);
      list.add(2);
      list.add(5);
      list.add(4);
      list.add(8);
      list.add(3);
      list.add(7);
      maxWTr(list);

    }

}
