package placement;

public class lowestCommonAncestor {

    // Node class for Binary Tree
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Building Binary Tree from given array representation
    static int idx = -1;
    public static Node buildBinaryTree(int[] nodes) {
        idx++;
        if (idx >= nodes.length || nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildBinaryTree(nodes);
        newNode.right = buildBinaryTree(nodes);
        return newNode;
    }

    // APPROACH 1 (HAVE A LOOK!)
//    // Recursive function to find Lowest Common Ancestor (LCA)
//    public static Node lowestCommonAncestor(Node root, int n1, int n2) {
//        if (root == null) {
//            return null;
//        }
//
//        // If the root itself is one of the targets, return root
//        if (root.data == n1 || root.data == n2) {
//            return root;
//        }
//
//        // Search in left and right subtrees
//        Node leftLCA = lowestCommonAncestor(root.left, n1, n2);
//        Node rightLCA = lowestCommonAncestor(root.right, n1, n2);
//
//        // If both left and right subtrees return non-null, this root is the LCA
//        if (leftLCA != null && rightLCA != null) {
//            return root;
//        }
//
//        // Otherwise, return whichever is non-null (either leftLCA or rightLCA)
//        return (leftLCA != null) ? leftLCA : rightLCA;
//    }

    // APPROACH 2
    public static Node lowestCommonAncestor(Node root, int n1, int n2) {
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node leftLca = lowestCommonAncestor(root.left, n1, n2);
        Node rightLca = lowestCommonAncestor(root.right, n1, n2);

        // In case inme se koi ek me valid root nahi mila to dusre me hoga
        if(leftLca==null){
            return rightLca;
        }
        if(rightLca==null){
            return leftLca;
        }
        // agar dono ke andar valid values hai then return that root
        return root;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        /**
                 1
               /   \
              2     3
            /  \     \
           4    5     6
         */
        Node tree = buildBinaryTree(nodes);

        int n1 = 4, n2 = 5;
        Node lca = lowestCommonAncestor(tree, n1, n2);
        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + (lca != null ? lca.data : "null"));
    }
}
