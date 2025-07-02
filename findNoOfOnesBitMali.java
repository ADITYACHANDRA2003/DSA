package placement;

public class findNoOfOnesBitMali {


    public static int clearIBits(int n){
        int count = 0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n>>=1;
        }
        return count;
    }
    public static void main(String[] args) {
       int n = 2048;
       System.out.println(clearIBits(n));
    }
}
