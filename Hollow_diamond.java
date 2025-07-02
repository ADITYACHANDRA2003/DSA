package placement;

import java.util.Scanner;

public class Hollow_diamond {
    public static void main(String[] args) {
        int i,j,n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(i=1;i<=n;i++){
            for(j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(j=1;j<=2*(i-1)-1;j++){
               System.out.print(" ");
            }
            if(i>1) {
                    System.out.print("*");
            }
            System.out.println();
        }
        for(i=n-1;i>0;i--) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (j = 1; j <= 2 * (i - 1) - 1; j++) {
                System.out.print(" ");
            }
            if (i > 1) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
