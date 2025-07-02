package placement;

public class searchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findIndex(arr,0,arr.length-1,6));
    }
    public static int findIndex(int[] arr, int si, int ei, int tar) {
        if(si>ei) return -1;
        int mid = si + (ei-si)/2;
        if(arr[mid]==tar){
            return mid;
        }
        //L1
        if(arr[si]<=arr[mid]) {
           if(arr[si]<=tar && arr[mid]>=tar) return findIndex(arr,si,mid-1,tar);
           else return findIndex(arr,mid+1,ei,tar);
        }
        //L2
        else{
            if(arr[mid]<=tar && arr[ei]>=tar) return findIndex(arr,mid+1,ei,tar);
            else return findIndex(arr,si,mid-1,tar);
        }
    }
}
