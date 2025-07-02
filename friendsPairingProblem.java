package placement;

public class friendsPairingProblem {
    public static void main(String[] args) {
        System.out.println(noOfWays(4));
    }
    public static int noOfWays(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int singleWays = noOfWays(n-1);
        int pairWays = noOfWays(n-2);
        return singleWays+(n-1)*pairWays;
    }
}
