package placement;

public class implementationOfStackUsingArray {
    public static class Stack{

        public static int top = -1;

        static int[] arr = new int[10];

        //isEmpty
        public static boolean isEmpty(){
            return top == -1;
        }

        // Push
        public static void push(int x){
            if(top == arr.length-1){
                System.out.println("Stack is full");
            }
            arr[++top] = x;
        }

        //Pop
        public static int pop(){
            if(top == -1){
                System.out.println("Stack is empty");
            }
            return arr[top--];
        }

        //Peek
        public static int peek(){
            if(top == -1){
                System.out.println("Stack is empty");
            }
            return arr[top];
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
