package placement;

public class Subarray {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        int i,j,k,n =arr.length,ts=0;
        for(i=0;i<n;i++) {
            for (j = i; j < n; j++) {
                System.out.print("[");
                for (k = i; k <= j; k++) {
                    System.out.print(arr[k] + ",");
                }
                System.out.print("]" + " ");
                ts++;
            }
            System.out.println();
        }
        System.out.println("Subarray length: " + ts);
    }
}
