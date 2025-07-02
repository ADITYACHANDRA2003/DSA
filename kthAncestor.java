package placement;

public class kthAncestor {

    public static class Node{

        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    public static Node buildTree(int[] arr){
        idx++;
        if( idx>=arr.length || arr[idx]==-1){
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);
        return newNode;
    }

    public static int KAncestor(Node root, int element, int K){
        if(root==null){      // if root is null no valid value
            return -1;
        }
        if(root.val==element){        // if we found the element node then return 0
            return 0;
        }
        int left = KAncestor(root.left,element,K);          //check in the left of root
        int right = KAncestor(root.right,element,K);        //check in the right of root

        //backtracking
        int max = Math.max(left,right);
        if(max!=-1){                  // Confirming whether max is valid or not
            if(max+1 == K){           // a root adding himself(+1) and then checking whether he is the Kth ancestor
                System.out.println(root.val +" ");
            }
            return max+1;     // returning the depth
        }
        return -1;     // else -1
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);

        /**
                1
              /  \
             2    3
           /  \    \
          4    5    6

         */
        KAncestor(root,5,  2);   // i want the 2nd ancestor of the 5
    }
}
