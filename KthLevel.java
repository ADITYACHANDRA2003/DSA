package placement;

import java.util.LinkedList;
import java.util.Queue;

public class KthLevel {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int idx = -1;
    public static Node buildTree(int[] arr){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);
        return newNode;
    }

    // Kth level
    // iterative approach
//    public static void KthLevel(Node root,int k){
//        if(root==null){
//            return;
//        }
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        q.add(null);
//        int i = 1;
//        while(!q.isEmpty()){
//            Node cur = q.remove();
//            if(cur==null){
//                i++;
//                if(i==k) {
//                    System.out.println();
//                }
//                if(q.isEmpty()){
//                    break;
//                }
//                else{
//                    q.add(null);
//                }
//            }
//            else{
//                if(i==k){
//                    System.out.print(cur.data+" ");
//                }
//                if(cur.left!=null){
//                    q.add(cur.left);
//                }
//
//                if(cur.right!=null){
//                    q.add(cur.right);
//                }
//            }
//        }
//    }

    // recursive approach
    public static void KthLevel(Node root,int level ,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        KthLevel(root.left,level+1,k);
        KthLevel(root.right,level+1,k);
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        /**
                1
              /  \
             2    3
           /  \    \
          4    5    6

         */
        Node tree = buildTree(nodes);
        KthLevel(tree,1,3);
    }
}
