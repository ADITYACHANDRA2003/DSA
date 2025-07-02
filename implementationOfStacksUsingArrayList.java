package placement;

import java.util.ArrayList;

class implementationOfStacksUsingArrayList {
    static class Stack {
        static ArrayList<Integer> s = new ArrayList<>();

        //IS EMPTY
        public static boolean isEmpty(){
            return(s.size()==0);
        }
        //Push
        public static void push(int x) {
            s.add(x);
        }
        //Pop
        public static int pop() {
            if(s.isEmpty()){
                return(-1);
            }
            int val = s.get(s.size()-1);
            s.remove(s.size()-1);  // O(1) Since we are removing from end
            return val;
        }
        //Peek
        public static int peek() {
            if(s.isEmpty()){
                return(-1);
            }
            return s.get(s.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

}