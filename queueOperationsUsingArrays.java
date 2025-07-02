package placement;

public class queueOperationsUsingArrays {


    public static class Queue{
         static int[] arr;
         static int rear;
         static int size;
         static int count;

        Queue(int capacity){
            arr = new int[capacity];
            size = capacity;
            rear = -1;
            count = 0;
        }

        public static boolean isEmpty(){
            return rear==-1;
        }

        // O(1)
        public static void enque(int data){
            if(rear==size-1){
                System.out.println("Queue is full");
                return;
            }
            count++;
            arr[++rear] = data;
        }

        // O(n)
        public static int deque(){
            if(rear==-1){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear--;
            count--;
            return front;
        }

        public static int peek(){
            if(rear==-1){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

        public static int getSize(){
            return count;
        }
    }



    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);
        System.out.println("the size of queue is: " + q.getSize());

        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.deque();
            System.out.println("the size of queue is: " + q.getSize());
        }

        q.deque();
    }
}
