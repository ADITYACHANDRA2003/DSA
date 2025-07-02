package placement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class maxLengthChainOfPairs {

    // T.C is O(nlogn) due to sorting
    public static void findMaxLen(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));
        int maxLen = 0;  // or better assign it directly to 1 since there will always be one element
        int lastEle = arr[0][1];
        maxLen = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0] > lastEle) {
                maxLen++;
                lastEle = arr[i][1];
            }
        }
        System.out.println("Max Length of Chain is: "+maxLen);
    }
    public static void main(String[] args) {
        int[][] pair = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        findMaxLen(pair);
    }
}
