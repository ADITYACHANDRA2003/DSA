package placement;

public class implementationOfStacksUsingLl {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    public static class Stack {
        // Is Empty
        public static boolean isEmpty() {
            return head == null;
        }

        // Push
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head; // Set next to the previous head
            head = newNode; // Move head to the new node
        }

        //Pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int value = head.data;
            head = head.next;
            return value;
        }

        //Peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());

        }
    }
}
