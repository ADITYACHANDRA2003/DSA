package placement;

// Time Complexity of this is O(logn)
public class fastExponent {

    public static int fastExponentiation(int n, int k) {
        int ans = 1;

        while(k>0){          //  Checking L.S.B in every iteration
            if((n&1)!=0){
                ans = ans*n;
            }
            n = n*n;
            k>>=1;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fastExponentiation(5,3));
    }
}
