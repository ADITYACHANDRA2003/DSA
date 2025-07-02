package placement;

public class validateBST {
    public static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static Node insert(Node root,int data) {
       if(root == null) {
           root = new Node(data);
           return root;
       }
       if(data < root.data) {
           root.left = insert(root.left,data);
       }
        else {
            root.right = insert(root.right,data);
        }
        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean isValid(Node root,Node min,Node max) {
        if(root == null) {
            return true;
        }
        if(min!=null && root.data<=min.data){   // checking whether min < root or not
            return false;
        }
        if(max!=null && root.data>=max.data){  // checking whether max > root or not
            return false;
        }
        return isValid(root.left,min,root) && isValid(root.right,root,max);  // checking the left and right
        // if any of them fails it is not a valid BST
    }
    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        Node root = null;
        for(int i=0;i<values.length;i++) {
            root = insert(root,values[i]);
        }
        inorder(root);
        System.out.println();
        if(isValid(root,null,null)) {
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }
    }
}