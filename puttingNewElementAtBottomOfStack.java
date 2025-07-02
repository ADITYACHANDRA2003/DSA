package placement;

import java.util.*;

public class puttingNewElementAtBottomOfStack {
    public static void PuttingElementAtBottom(Stack<Integer> s,int x) {
        if(s.isEmpty()){
            s.push(x);
            return;
        }
        int val = s.pop();
        PuttingElementAtBottom(s,x); // Recursion
        s.push(val); // Backtracking
    }

        public static void main(String[] args) {
            Stack<Integer> s = new Stack<Integer>();
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);
            s.push(5);
            PuttingElementAtBottom(s, 10);
           while(!s.isEmpty()) {
               System.out.println(s.pop());
           }
        }
}

