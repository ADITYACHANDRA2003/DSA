package placement;

import java.util.LinkedList;
import java.util.Queue;

public class sizeOfLargestBSTInBT {
    public static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    static int maxBST = 0;
    public static Info getLargestBST(Node root) {
        if(root == null) return new Info(0,Integer.MAX_VALUE,Integer.MIN_VALUE,true);

        Info leftInfo = getLargestBST(root.left);
        Info rightInfo = getLargestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;  // size calculation
        int min = Math.min(root.data,Math.min(leftInfo.min, rightInfo.min)); // we are calculating min and max
        int max = Math.max(root.data,Math.max(leftInfo.max, rightInfo.max)); // because it is helpful in checking
        // whether the BST is valid or not

        if(root.data >= rightInfo.min || root.data <= leftInfo.max) { // checking if it is not valid
            return new Info(size, min, max, false);
        }
        if(leftInfo.isBST && rightInfo.isBST) {    // if valid do this
            maxBST = Math.max(maxBST, size);       // having the maximum size of the valid BST
            return new Info(size, min, max, true);
        }
        return new Info(size, min, max, false);
    }

    public static void main(String[] args) {
        int[] values = {50,30,5,20,60,45,70,65,80};
        Node root = new Node(values[0]);
        root.left = new Node(values[1]);
        root.left.left = new Node(values[2]);
        root.left.right = new Node(values[3]);
        root.right = new Node(values[4]);
        root.right.left = new Node(values[5]);
        root.right.right = new Node(values[6]);
        root.right.right.left = new Node(values[7]);
        root.right.right.right = new Node(values[8]);

        Info largestBST = getLargestBST(root);
        System.out.println("the largest BST in the BT is of Size :- "+ maxBST);
    }
}
