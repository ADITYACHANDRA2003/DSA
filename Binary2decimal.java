package placement;
import java.util.*;

public class Binary2decimal {

    public static int binary2decimal(int n){
        int a,res =0,i=0;
        if(isValidBinary(n)) {
            while (n > 0) {
                a = n % 10;
                res = res + (int) Math.pow(2, i) * a;
                i++;
                n /= 10;
            }
        }
        else
            return 0;
            return res;

    }
    public static boolean isValidBinary(int n) {
        while (n > 0) {
            if (n % 10 > 1) {
                return false; // Contains a digit other than 0 or 1
            }
            n /= 10;
        }
        return true;
    }



    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the binary no.");
        n = sc.nextInt();
        System.out.println("the decimal is "+binary2decimal(n));
    }
}

