package placement;

// O(n)
//public class powUsingRecursion  {
//    public static void main(String[] args) {
//        System.out.println(pow(2,10));
//    }
//
//    public static int pow(int base, int exponent) {
//       if(exponent == 0)
//           return 1;
//       return base*pow(base,exponent-1);
//    }
//}
// OPTIMIZED APPROACH O(logn)
public class powUsingRecursion  {
    public static void main(String[] args) {
        System.out.println(pow(3,4));
    }

    public static int pow(int base, int exponent) {
        if(exponent == 0) return 1;
        int halfPower = pow(base, exponent / 2);// only logn expression in function else all are constant
        int halfPowerSquared = halfPower * halfPower; // even this is constant
        if(exponent%2 == 0){
            return halfPowerSquared; // Since if 2^4 = 2^2 * 2^2 for even powers
        }
            return base*halfPowerSquared; // Since if 2^5 = 2 *2^2 * 2^2 for odd powers
    }
}

