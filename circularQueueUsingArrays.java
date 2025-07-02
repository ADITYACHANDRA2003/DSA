package placement;

public class circularQueueUsingArrays {
    public static class CirQueue {
        private int rear;
        private int front;
        private int size;
        private int[] arr;
        private int count;

        CirQueue(int Capacity) {
            rear = -1;
            front = -1;
            size = Capacity;
            count = 0;
            arr = new int[Capacity];
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public boolean isFull() {
            return (rear + 1)%size == front;
        }

        // O(1)
        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) { // First insertion case
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = item;
            count++;
        }

        // O(1)
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int item = arr[front]; // Store front value before updating
            front = (front + 1) % size;
            count--;

            if (count == 0) { // Reset front and rear when the queue becomes empty
                front = -1;
                rear = -1;
            }

            return item;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public int getSize() {
            return count;
        }
    }

    public static void main(String[] args) {
        CirQueue queue = new CirQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // This should print "Queue is full"

        System.out.println("The size of the circular queue is: " + queue.getSize());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Front of the circular queue: " + queue.peek());
        queue.enqueue(6); // Should work since one element was dequeued

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
