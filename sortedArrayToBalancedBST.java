package placement;

import java.util.LinkedList;
import java.util.Queue;

public class sortedArrayToBalancedBST {
        public static class Node{
            int data;
            Node left,right;

            public Node(int data) {
                this.data = data;
                left = right = null;
            }
        }

        public static Node balancedBST(int[] arr,int first,int last) {
            if(first>last)
                return null;

            int mid = first + (last - first) / 2;
            Node root = new Node(arr[mid]);
            root.left = balancedBST(arr , first, mid - 1);
            root.right = balancedBST(arr, mid + 1, last);
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

        public static void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp==null){
                    System.out.println();
                    if(q.isEmpty())
                        break;
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(temp.data+" ");
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                }
            }
        }
        public static void main(String[] args) {
            int[] values = {3,5,6,8,10,11,12};
            System.out.println();
            Node root =  balancedBST(values,0,values.length-1);
            levelOrder(root);
            System.out.println();
            inorder(root);
        }
}
