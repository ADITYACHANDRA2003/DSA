package placement;

class Solution {
    public static void reverseArray(int arr[]) {
        int n = arr.length;
        int[] rev = new int[n];
        for(int i =0;i<n;i++){
            rev[i] = arr[n-1-i];
        }
        System.out.print("[");
        for(int i=0;i<n-1;i++){
            System.out.print(rev[i]+",");
        }
        System.out.print(rev[n-1]+"]");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reverseArray(arr);
    }
}