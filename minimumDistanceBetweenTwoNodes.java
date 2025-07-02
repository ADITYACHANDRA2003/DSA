package placement;

public class minimumDistanceBetweenTwoNodes {

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    public static Node buildTree(int[] arr) {
        idx++;
        if (idx >= arr.length || arr[idx] == -1) {
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);

        return newNode;

    }

    public static Node Lca(Node root, int n1, int n2) {
        if (root == null || root.val == n1 || root.val == n2) {
            return root;
        }

        Node left = Lca(root.left, n1, n2);
        Node right = Lca(root.right, n1, n2);

        if (left != null && right != null) {
            return root;  // ✅ If both left & right return non-null, root is the LCA
        }

        return (left != null) ? left : right;  // ✅ If only one side is non-null, return it
    }


    public static int lcaDistance(Node root, int tar) {
        if(root == null){
            return -1;
        }
        if(root.val == tar){
            return 0;
        }
        int leftDis = lcaDistance(root.left,tar);
        int rightDis = lcaDistance(root.right,tar);

        if(leftDis == -1 && rightDis == -1){
            return -1;
        }
        else if(leftDis == -1){
            return rightDis+1;
        }
        else{
            return leftDis+1;
        }
    }

    // minimum distance between two points function
    public static int minimumDistance(Node root,int n1,int n2) {
        Node lca =Lca(root,n1,n2);
        int leftDis = lcaDistance(lca,n1);
        int rightDis = lcaDistance(lca,n2);
        return rightDis + leftDis;
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
        Node tree = buildTree(nodes);
        int n1 = 4, n2 = 5;
        System.out.println("The Minimum distance between "+n1+" and "+n2+" is "+minimumDistance(tree,n1,n2));
    }
}
