package placement;

import java.util.Scanner;

class staircaseSeach2DArray {

    public static boolean Staircase(int[][] arr,int x){
       int n = arr.length,m = arr[0].length,i=0;
       while(i<n && m>0){
           if(arr[i][m-1]==x){
               return true;
           }
           else if(x>arr[i][m-1]){
               i++;
           }
           else if(x<arr[i][m-1]){
               m--;
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
        if(Staircase(nums,n)){
            System.out.println("Element found");
        }
        else
            System.out.println("Element not found");
    }
}