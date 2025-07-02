package placement;

public class findPallindromeLinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public static void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        if(size ==1)
           head.next = newNode;
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to check if the linked list is a palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node mid = middleElement(head); // Find the middle node
        Node secondHead = reverseList(mid.next); // Reverse the second half
        mid.next = secondHead; // Link mid to the reversed list

        Node firstHead = head;
        Node temp = secondHead; // Store reference for restoring later

        while (secondHead != null) { // Compare only the second half
            if (firstHead.data != secondHead.data) {
                mid.next = reverseList(temp); // Restore the original order
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        mid.next = reverseList(temp); // Restore the list before returning
        return true;
    }
    // SLOW-FAST POINTER APPROACH
    // Find the middle element using the slow-fast pointer approach
    public static Node middleElement(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {  // in case of even no. of nodes when slow pointer reaches mid the fast
            slow = slow.next;     // +1            // pointer should be at case fast!=null and vice-versa [TEST IT YOURSELF!]
            fast = fast.next.next;  // +2
        }
        return slow;
    }

    // Reverse the linked list and return the new head
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // Return new head of the reversed list
    }

    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
       findPallindromeLinkedList ll = new findPallindromeLinkedList();
       ll.head = new Node(1);
       add(2);
       add(3);
       add(4);
       add(3);
       add(3);
       add(2);
       add(1);
       print(head);
       System.out.println(isPalindrome(head));
    }
}
