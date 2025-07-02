package placement;

// T.C O(n*n!)
public class stringPermutationUsingBacktracking {
    public static void main(String[] args) {
        String str = "abc";
        permutation(str,"");
    }
    public static void permutation(String str, String ans) {
        if(str.length()==0) {
            System.out.println(ans);
            return;
        }
         for(int i=0;i<str.length();i++) {
             char curr = str.charAt(i);
             String newStr = str.substring(0, i) + str.substring(i+1); // this will remove the character at i
             permutation(newStr,ans+curr);
         }
    }
}
