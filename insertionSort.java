package placement;

public class insertionSort {

    public static void insertion(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && curr<arr[prev]){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] nums = {5,3,2,1,6,8,5,3,9,1};
        insertion(nums);
    }
}
