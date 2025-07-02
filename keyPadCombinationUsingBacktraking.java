package placement;

public class keyPadCombinationUsingBacktraking {
    public static void printLetters(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);  // Print the formed string
            return;
        }

        // Corrected letters array (without commas inside)
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int digit = str.charAt(0) - '0';  // Convert char to int
        String mappedLetters = letters[digit];  // Get corresponding letters

        for (int i = 0; i < mappedLetters.length(); i++) {
            printLetters(str.substring(1), ans + mappedLetters.charAt(i));  // Recursive call
        }
    }

    public static void main(String[] args) {
        String str = "48";
        String ans = "";
        printLetters(str, ans);
    }
}
