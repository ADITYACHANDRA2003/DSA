package placement;

public class cycleDetectionInLinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; // java will automatically assign it to zero

    // to add element at last O(1)
    public static void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }


    // print LinkedList O(n)
    public static void printList(Node head){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Detecting Cycles  (Floyd's Cycle detection algorithm)
    public static boolean isCycle(Node head) {
        if(head == null){
            return false;
        }
        Node fastPtr = head;
        Node slowPtr = head;

        while(fastPtr != null && fastPtr.next!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(fastPtr == slowPtr){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        head = new Node(1);
        tail = head;
        size++;
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);
        printList(head);
        System.out.println("the size of the list is: "+size);
        System.out.println("is there cycle? "+isCycle(head));
        tail.next = head;
        System.out.println("is there any cycle? "+ isCycle(head));
    }

}
