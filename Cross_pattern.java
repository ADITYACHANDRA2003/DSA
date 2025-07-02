package placement;
import java.util.Scanner;

// Practice Session 6
public class Cross_pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        // Upper part of the cross
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
             if(i-j==0 || i+j==n+1){
                 System.out.print("*");
             }
             else
                 System.out.print(" ");
            }
            System.out.println();
        }
    }
}

