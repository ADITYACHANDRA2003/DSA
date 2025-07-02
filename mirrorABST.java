package placement;

public class mirrorABST {
     public static class Node{
            int data;
            Node left,right;

            public Node(int data) {
                this.data = data;
                left = right = null;
            }
        }
        public static Node insert(Node root, int data) {
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
        // Mirror a BST
    public static Node mirror(Node root) {
         if(root == null) {
             return null;
         }
         Node left = mirror(root.left); // Recursively mirroring the left subtree
         Node right = mirror(root.right); // Recursively mirroring the right subtree

        // backtracking
        root.left = right;
        root.right = left;

        return root;
    }


        public static void main(String[] args) {
            int[] values = {5,1,3,4,2,7};
            Node root = null;
            for(int i=0;i<values.length;i++) {
                root = insert(root,values[i]);
            }
            inorder(root);
            System.out.println();
            System.out.println("The BST is mirrored:-");
            mirror(root);
            inorder(root);

     }
}
