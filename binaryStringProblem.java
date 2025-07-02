package placement;

public class binaryStringProblem {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        binaryStringProblem(3,'0',sb);
    }
    public static void binaryStringProblem(int size, char lastPlace, StringBuilder sb) {
        if(size ==0){
            System.out.println(sb);
            return;
        }
        // always insert 0 as it can be at any position
        binaryStringProblem(size-1,'0',new StringBuilder(sb).append("0"));
        if(lastPlace=='0')  binaryStringProblem(size-1,'1',new StringBuilder(sb).append("1"));
    }
}
