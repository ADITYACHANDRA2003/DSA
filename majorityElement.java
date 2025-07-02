package placement;

import java.util.HashMap;
import java.util.Set;

public class majorityElement {

    // O(n)
    public static void returnMajor(int[] arr, int k){
        int n = arr.length;
        int threshold = n/k;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int ele : arr){

            // replace it with
//            if(hm.containsKey(ele)){
//                hm.put(ele,hm.get(ele)+1);
//            }else{
//                hm.put(ele,1);
//            }
            // this!
            hm.put(ele,hm.getOrDefault(ele,0)+1); // getOrDefault is checking if the element is not present it
            // will set the provided default value otherwise it will move with the flow (i.e here adding 1)
        }

        // no need to make set to store the keys just directly asign it to for each loop
        for(int ele : hm.keySet()){
            if(hm.get(ele) > threshold){
                System.out.println("Element with frequency > "+threshold+" is  "+ele+" with frequency = "+hm.get(ele));
            }
        }

    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,1,3,1,5,1};
        int k = 3;
        returnMajor(nums,k);
    }
}
