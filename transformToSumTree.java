package placement;

import java.util.LinkedList;
import java.util.Queue;

public class transformToSumTree {
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

        public static void printTree(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node cur = q.poll();
                if(cur==null){
                    System.out.println(" ");
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(cur.val+" ");
                    if(cur.left!=null){
                        q.add(cur.left);
                    }
                    if(cur.right!=null){
                        q.add(cur.right);
                    }
                }
            }
        }

    // Function to convert the tree to a sum tree
    public static int sumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        int oldValue = root.val;
        root.val = leftSum + rightSum;

        return root.val + oldValue;
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

            printTree(root);
            sumTree(root);
            System.out.println();
            printTree(root);
        }

}
