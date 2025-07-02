package placement;

public class ZigZagLL {
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

    public static Node middleElement(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;  // Mid-point
    }

    public static Node reverseList(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head of reversed list
    }
    // ZIG ZAG METHOD
    public static void zigZagLl(Node head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle and split the list
        Node mid = middleElement(head);
        Node secondHalf = mid.next;
        mid.next = null;  // Break the list

        // Step 2: Reverse the second half
        secondHalf = reverseList(secondHalf);

        // Step 3: Merge both halves in a zigzag pattern
        // Imagine this part
        Node firstHalf = head;
        Node temp1, temp2;
        while (firstHalf != null && secondHalf != null) {
            temp1 = firstHalf.next;
            temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

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
        addFirst(7);
        addFirst(6);
        addFirst(5);
        addFirst(4);
        addFirst(3);
        addFirst(2);
        addFirst(1);

        System.out.println("Original Linked List:");
        printList(head);

        System.out.println("Zig-Zag Linked List:");
        zigZagLl(head);
        printList(head);

    }
}
