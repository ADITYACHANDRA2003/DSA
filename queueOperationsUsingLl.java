package placement;

public class queueOperationsUsingLl {

    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue {

        public static int count=0;
        public static Node head=null;
        public static Node tail=null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void enqueue(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
            count++;
        }

        public static int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            count--;
            int val = head.data;
            head = head.next;

            if (head == null) {  // imp
                tail = null;
            }

            return val;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }

        public static int getSize() {
            return count;
        }
    }

    public static void main(String[] args) {
     Queue queue = new Queue();
     queue.enqueue(1);
     queue.enqueue(2);
     queue.enqueue(3);
     queue.enqueue(4);
     queue.enqueue(5);

     System.out.println("size: " + queue.getSize());
     System.out.println("peek: " + queue.peek());
     while (!queue.isEmpty()) {
         System.out.println(queue.dequeue());
     }
     System.out.println("size: " + queue.getSize());
    }
}
