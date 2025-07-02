package placement;

import java.util.Scanner;

public class Decimal2binary {

    public static int Decimal2Binary(int n) {
        int res = 0,a,i=0;
        while (n>0) {
           a = n%2;
           res = res + (int)(a*Math.pow(10,i));
           i++;
           n = n/2;
        }
        return res;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.");
        n = sc.nextInt();
        System.out.println("the decimal is "+Decimal2Binary(n));
    }

}
