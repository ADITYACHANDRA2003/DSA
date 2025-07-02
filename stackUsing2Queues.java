package placement;

import java.util.Queue;
import java.util.LinkedList;

public class stackUsing2Queues {
    public static class Stack {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();  // Both queues should be empty
        }

        public void push(int x) {
            q1.add(x);  // Always add to q1
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            // Move elements from q1 to q2, leaving only last element in q1
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            // Remove the last element, which is the top of the stack
            int top = q1.remove();

            // Swap q1 and q2 to maintain order
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            // Why do we swap q1 and q2?
            //In our implementation of the stack using two queues, we always:
            //
            //Push elements into q1.
            //Use q2 as a temporary helper during pop() and peek() operations.
            //After performing a pop() or peek() operation, all elements except the last one have been transferred
            // from q1 to q2. At this point:
            //q1 is empty.
            //q2 contains all remaining elements in the correct order.
            //If we don't swap q1 and q2, then in the next operation, elements will still be in q2, which breaks
            // the logic since we always assume new elements go into q1.

            return top;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            // Move elements from q1 to q2, leaving only last element in q1
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            // Get the last element (top of the stack)
            int top = q1.peek();
            q2.add(q1.remove());  // Move it to q2

            // Swap q1 and q2 to maintain order
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return top;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Peek: " + stack.peek()); // Should print 5

        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // Should print 5 4 3 2 1
        }
    }
}
