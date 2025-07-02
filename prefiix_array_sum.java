package placement;

public class prefiix_array_sum {
    public static void main(String[] args) {
        int[] arr = {1,-2,6,-1,3};
        int[] prefix = new int[arr.length];
        int i,j,start=0,end=0,currsum=0,maxsum=Integer.MIN_VALUE;

        // Calculating prefix array
        prefix[0] = arr[0];
        for(i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
        // Calculating subarray sum
        for(i=0;i<arr.length;i++){
            start = i;
            for(j=i;j<arr.length;j++){
             end = j;
             currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
            }
            if(maxsum<currsum){
                maxsum = currsum;
            }
        }
        System.out.println("Maximum Sum is = "+maxsum);
    }
}
