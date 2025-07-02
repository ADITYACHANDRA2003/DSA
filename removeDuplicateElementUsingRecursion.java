package placement;

public class removeDuplicateElementUsingRecursion {
    public static void main(String[] args) {
        String str ="aappnacollege";
        boolean[] map = new boolean[26];
        StringBuilder sb = new StringBuilder();
        System.out.println(removeDuplicates(str,0,sb,map ));
    }
    public static String removeDuplicates(String str,int idx,StringBuilder sb,boolean[] map) {
       int n = str.length();
       if(idx==n) return sb.toString();
       char ch = str.charAt(idx);
       if(!map[ch-'a']) {
        map[ch-'a'] = true;
        sb.append(ch);
       }
       return removeDuplicates(str,idx+1,sb,map);
    }
}
