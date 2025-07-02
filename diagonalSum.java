package placement;

public class diagonalSum {

    public static void diagoSum(int[][] arr){
        int sum = 0,sum1 =0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==j){
                    sum+=arr[i][j];
                } else if (i+j==arr.length-1) {
                    sum1+=arr[i][j];
                }
            }

        }
        System.out.println(sum);
        System.out.println(sum1);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}
        };
        diagoSum(arr);

    }
}
