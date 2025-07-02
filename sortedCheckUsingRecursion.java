package placement;

public class sortedCheckUsingRecursion {
    public static void main(String[] args) {
     int[] arr = {1,7,3,5,4,10};
     int len = arr.length;
     if(dn(arr,len-1)){
         System.out.println("yes");
     }
     else{
         System.out.println("no");
     }
    }

    public static boolean dn(int[] arr,int n) {
        if(n==0){
            return true;
        }
        if(arr[n]<arr[n-1]){
            return false;
        }
        return dn(arr,n-1);
    }
}
