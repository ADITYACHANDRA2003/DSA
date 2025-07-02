package placement;

import java.util.HashMap;

public class validAnagramsUsingHashMap {

    public static boolean isAnagram(String a, String b) {

        // edge case
        if(a.length() != b.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : b.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for(int c : map.values()) {
            if(c != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "knee", s2 = "keen";
        System.out.println((isAnagram(s1,s2)) ? "Anagram" : "Not Anagram");
    }
}
