package placement;
import java.util.Arrays;

public class anagrams {
    public static void main(String[] args) {
        String str = "race";
        String str1 = "cear";

        // Check if lengths are equal
        if (str.length() != str1.length()) {
            System.out.println("not anagrams");
            return;
        }

        // Convert strings to character arrays and sort them
        char[] arr1 = str.toCharArray();
        char[] arr2 = str1.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("anagrams");
        } else {
            System.out.println("not anagrams");
        }
    }
}
