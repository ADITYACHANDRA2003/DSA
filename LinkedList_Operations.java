package placement;

public class LinkedList_Operations {
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

    // to add element at first  O(1)
    public static void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

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

    // add Element in Middle O(n)
    public static void addInMiddle(int data, int index) {
        // Edge case: inserting at the beginning
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        // Traverse to the node before the given index
        for (int i = 1; i < index; i++) {
            if (temp == null || temp.next == null) {  // Check out-of-bounds case
                System.out.println("Invalid index: " + index);
                return;
            }
            temp = temp.next;
        }
        size++;
        // Correct insertion logic
        newNode.next = temp.next; // first assign
        temp.next = newNode; // then modify not vice-versa

        // Edge case: If inserted at the last position, update tail
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // remove first Element O(1)

    public static int removeFirst() {

        //edge cases
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        size--;
        // main work
        int val = head.data;
        head = head.next;  // Garabage Collector will free the previous node automatically
        return val;
    }

    // remove Last Element  O(n)
    public static int removeLast() {
        Node temp = head;
        //edge cases
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        size--;
        // main work
        int val = tail.data;
        for (int i = 1; i < size-1; i++) {  // imagine this loop
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        return val;
    }

    // Recursive search method O(n)
    // this code is actually finding the key if key is not found it return -1 and ends if it founds then it return
    // 0(assigning the node's index where is found as 0) then it backtracks to the head back and adds 1 in every node
    // till it reach head and the correct index is now found.
    public static void recursiveSearch(int key) {
        System.out.println(helperFunction(head , key));
    }
    public static int helperFunction(Node list, int key) {
        if(list == null){ // if key not found return -1
            return -1;
        }
        if(list.data == key){
            return 0;
        }
        int idx = helperFunction(list.next, key);  // it will return 0 if found key else -1
        if(idx == -1){
            return -1;
        }
        return idx+1; // backtracking
    }

    // Reverse a Linked List
    public static void reverseList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            System.out.println("List has a single element");
            return;
        }

        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next; // Store next node
            curr.next = prev; // Reverse the link
            prev = curr;      // Move prev forward
            curr = next;      // Move curr forward
        }

        // Update head and tail
        tail = head;
        head = prev;
    }

    // print LinkedList O(n)
    public static void printList(Node list){
        if(list == null){
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
    public static void main(String[] args){
        addFirst(2);
        addFirst(1);
        addLast(10);
        addLast(20);
        addInMiddle(25, 2);
        printList(head);
        System.out.println("size of the list "+size);
        System.out.println("removed first element is "+removeFirst());
        printList(head);
        System.out.println("size of the list "+size);
        System.out.println("size of the list "+size);
        System.out.println("removed last element is "+removeLast());
        System.out.println("size of the list "+size);
        addFirst(3);
        addFirst(4);
        addFirst(5);
        printList(head);
        recursiveSearch(3);
        reverseList();
        printList(head);
    }

}
