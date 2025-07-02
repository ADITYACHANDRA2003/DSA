package placement;

public class firstOccuranceUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1,7,3,5,4,7,10};
        System.out.println(dn(arr,0,7));
    }

    public static int dn(int[] arr,int n,int key) {
        if(n >= arr.length){
            return -1;
        }
        if(arr[n] == key){
            return n;
        }
        return dn(arr,n+1,key);
    }
}

