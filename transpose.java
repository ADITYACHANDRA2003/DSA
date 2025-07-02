package placement;

class transpose {

    public static void transpose(int[][] arr) {
        int n = arr.length,m = arr[0].length;
        int[][] output = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output[j][i] = arr[j][i];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(output[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        transpose(nums);
    }
}