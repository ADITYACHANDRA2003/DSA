package placement;

import java.util.Stack;

public class reverseAStringUsingStack {

    public static String reverseStringS(String input) {
        Stack<Character> s = new Stack<>();
        StringBuilder res = new StringBuilder();
       if(input.length() == 0) {
           System.out.println("String is empty");
           return "";
       }
       int i=0;
       while(i!=input.length()){
           s.push(input.charAt(i));
           i++;
       }
       while(!s.isEmpty()){
           char val = s.pop();
           res.append(val);
       }
        return res.toString();
    }


    public static void main(String[] args) {
        String str = "Aditya";
        System.out.println(reverseStringS(str));
    }
}
