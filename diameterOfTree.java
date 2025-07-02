package placement;

import java.util.Queue;
import java.util.LinkedList;

public class diameterOfTree {

    // object for node creation
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // building binary tree
    static int idx = -1;
    public static Node buildBinaryTree(int[] nodes){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildBinaryTree(nodes);
        newNode.right = buildBinaryTree(nodes);
        return newNode;
    }

    //height
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //diameter of the tree (APPROACH 1)  O(n^2)
//    public static int diameter(Node root){
//        if(root == null){
//            return 0;
//        }
//
//        int leftDiameter = diameter(root.left);
//        int rightDiameter = diameter(root.right);
//
//        int leftHeight =  height(root.left);
//        int rightHeight = height(root.right);
//
//        int selfDiamter = leftHeight + rightHeight + 1;
//
//        return Math.max(selfDiamter,Math.max(leftDiameter, rightDiameter)) ;
//    }

    // APPROACH 2   O(n)

    public static class Info{
        int diam;
        int height;

        public Info(int diam, int height){
            this.diam = diam;
            this.height = height;
        }
    }

    public static Info diameter(Node root){
        if(root == null){
            return new Info(-0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.height+rightInfo.height+1);
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;

        return new Info(diam,height);
    }


    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        /**
                      1
                    /  \
                   2    3
                 /  \    \
                4    5    6
         */
        Node tree = buildBinaryTree(nodes);
        Info dia = diameter(tree);
        System.out.println(dia.diam);
    }
}
