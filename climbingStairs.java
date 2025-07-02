package placement;

import java.util.Arrays;

public class climbingStairs {

    // MEMOIZATION (TOP-DOWN)
    public static int nthStair(int n, int[] dp){
        if(n == 0 || n == 1) return 1;  // Base cases
        if(dp[n] != -1) return dp[n];   // if valid result is present Return stored result
        dp[n] = nthStair(n - 1, dp) + nthStair(n - 2, dp);
        return dp[n];
    }
//    // TABULATION
//    public static int nthStair(int n, int[] dp){
//        dp[0] = 1;
//        dp[1] = 1;
//        for(int i = 2; i <= n; i++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }

    public static void main(String[] args) {
        int n = 5;

        // MEMOIZATION CALL
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);  // Initialize with -1 Since n==0 is also a valid answer
        System.out.println(nthStair(n, dp));
    }
}
