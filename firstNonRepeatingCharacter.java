package placement;
import java.util.LinkedList;
import java.util.Queue;

public class firstNonRepeatingCharacter {

    public static void printFirstNR(String str){
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<Character>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch-'a']++;
            q.add(ch);

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printFirstNR(str);
    }
}
