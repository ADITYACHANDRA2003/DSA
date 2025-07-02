package placement;

public class countingSort {

    public static void counting(int[] arr){
        int n = arr.length,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           max = Math.max(max,arr[i]);
        }
        int[] count = new int[max+1];
        for(int i=0;i<count.length;i++){
            count[i] = 0;
        }
        for(int i=0;i<n;i++){
           count[arr[i]]++;
        }

        int j = 0;
        for(int i=0;i<count.length;i++){          // MAIN SORTING STEP
            while(count[i]>0){
                arr[j] = i;                       // WE ARE PUTTING THE OUTPUT IN THE ORIGINAL ARRAY
                j++;
                count[i]--;
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
     int[] arr = {5,3,2,1,6,8,2,8};
     counting(arr);
    }
}
