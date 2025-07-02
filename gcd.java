package placement;

public class gcd {
    public static void main(String[] args) {
        System.out.println(gcd(4,10));
    }
    public static int gcd(int a, int b) {
        if(a==0) return b;
        if(b==0) return a;
        return gcd(b%a,a);
    }
}
