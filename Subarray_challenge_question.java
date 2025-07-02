package placement;
// find the sum of elements of all subarrays and find min. and max.
public class Subarray_challenge_question {
    public static void main(String[] args) {
        int[] arr = {1,-2,6,-1,3};
        int i,j,k,n =arr.length,ts=0,sum=0,min=arr[0],max=0;
        for(i=0;i<n;i++) {
            int start =i;
            for (j = i; j < n; j++) {
                int end = j;
                System.out.print("[");
                for (k = start; k <= end; k++) {
                    System.out.print(arr[k] + ",");
                    sum = sum + arr[k];
                }
                System.out.print("]" + " "+" =>"+" "+sum+" ");
                if(sum>max){
                    max = sum;
                }
                if(sum<min){
                    min = sum;
                }
                ts++;
                sum=0;
            }
            System.out.println();
        }
        System.out.println("Subarray length: " + ts);
        System.out.println("min sum: " + min);
        System.out.println("max sum: " + max);
    }
}
