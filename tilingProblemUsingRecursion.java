package placement;

class tilingProblemUsingRecursion {
    public static void main(String[] args) {
       System.out.println(noOfWays(4));
    }
    public static int noOfWays(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        int horizontalCase = noOfWays(n-1);
        int verticalCase = noOfWays(n-2);
        return horizontalCase + verticalCase;
    }
}