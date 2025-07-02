package placement;
import java.util.Stack;

public class validParenthesis {

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                if (s.isEmpty()) return false; // agar string ke khatam hone se pahele stack khali the false

                char top = s.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return s.isEmpty(); // Ensure no unmatched opening brackets remain
    }

    public static void main(String[] args) {
        String str1 = "{[()]}";
        String str2 = "[({}])";

        System.out.println(isValid(str1) ? "True" : "False"); // Expected: True
        System.out.println(isValid(str2) ? "True" : "False"); // Expected: False
    }
}
