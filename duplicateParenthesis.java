package placement;

import java.util.Stack;

public class duplicateParenthesis {

    public static boolean isDuplicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                if (!s.isEmpty() && s.peek() == '(') { // Found empty '()' case
                    return true;
                }
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                }
                if (!s.isEmpty()) s.pop(); // Pop the opening '(' safely
            } else {
                s.push(ch); // Push all characters except ')'
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "((a+b)+(a-b))";   // No duplicate parentheses
        String str2 = "(((a+b)+(a-b)))"; // Contains redundant parentheses
        String str3 = "((a))";           // Contains redundant parentheses
        String str4 = "(a)";             // No duplicate parentheses
        String str5 = "(((a+b)))";       // Contains redundant parentheses

        System.out.println(isDuplicateParenthesis(str1) ? "Duplicate parenthesis" : "No Duplicate parenthesis");
        System.out.println(isDuplicateParenthesis(str2) ? "Duplicate parenthesis" : "No Duplicate parenthesis");
        System.out.println(isDuplicateParenthesis(str3) ? "Duplicate parenthesis" : "No Duplicate parenthesis");
        System.out.println(isDuplicateParenthesis(str4) ? "Duplicate parenthesis" : "No Duplicate parenthesis");
        System.out.println(isDuplicateParenthesis(str5) ? "Duplicate parenthesis" : "No Duplicate parenthesis");
    }
}
