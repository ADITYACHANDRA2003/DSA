package placement;

public class mergeSortInLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size; // Java initializes it to zero

    // Add element at the beginning (O(1))
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add element at the end (O(1))
    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Find the middle element
    public static Node middleElement(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head, fast = head.next; // Left-biased middle for even-sized lists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge Sort function
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle and split the list
        Node mid = middleElement(head);
        Node rightHead = mid.next;
        mid.next = null; // Break the list into two halves

        // Recursively sort both halves
        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(rightHead);

        // Merge sorted halves
        return merge(leftSorted, rightSorted);
    }

    // Merge two sorted linked lists
    public static Node merge(Node left, Node right) {
        Node dummy = new Node(-1); // Dummy node for easier merging
        Node temp = dummy;

        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next; // Move temp forward
        }

        // Attach remaining nodes
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }

        return dummy.next; // Return sorted list
    }

    // Print Linked List
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        addFirst(2);
        addFirst(1);
        addLast(10);
        addLast(20);
        addFirst(3);
        addFirst(4);
        addFirst(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Sort the linked list using Merge Sort
        head = mergeSort(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}
