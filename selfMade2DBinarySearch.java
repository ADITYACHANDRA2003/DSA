package placement;

import java.util.Scanner;

class selfMade2DBinarySearch {

    public static boolean search(int[][] arr,int x){
        int n = arr.length, m = arr[0].length;
        int first,last,mid,i;
        for(i=0;i<n;i++){
            first =0;
            last = m-1;  // THIS m IS VERY IMP! IF n IS USED IT WILL ITERATE OVER ROWS INSTEAD OF COLUMNS CAUSING
            mid = (first+last)/2; // TIME COMPLEXITY TO BE OF O(n^2) INSTEAD OF O(nlogn)

            while(first<=last){
                if(arr[i][mid]==x){
                    return true;
                }
                else if(arr[i][mid]>x){
                    last = mid -1;
                } else  {
                    first = mid +1;
                }
                mid = (first+last)/2;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] nums = {{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                        {32,33,39,50}
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the the element to be searched");
        int n = sc.nextInt();
        if(search(nums,n)){
            System.out.println("Element found");
        }
        else
            System.out.println("Element not found");
    }
}