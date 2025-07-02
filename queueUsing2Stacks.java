package placement;

import java.util.Stack;

public class queueUsing2Stacks {
    public static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty(); // agar kisi bhi stack me element hai to not empty
        }

        public void enqueue(int x) {
            s1.push(x);
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}
