package placement;

import java.util.ArrayList;

public class buildBST {

    public static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    // Inserting values in the BST
    public static Node insertVal(Node root ,int val){
       if(root==null){        // in case root is empty make a new node(root)
           root =new Node(val);
           return root;
       }
       if(val<root.data){
           root.left=insertVal(root.left,val);
       }
       else{
           root.right=insertVal(root.right,val);
       }
       return root;
    }

       // Seach in BST  O(H)
    public static boolean search(Node root,int key){
        if(root==null) {
            return false;
        }
            if(root.data==key){
                return true;
            }
            else if(key<root.data){
                return search(root.left,key);  // will automatically return true(if found) to the parent
            }
            else{
                return search(root.right,key);
            }
        }

        // delete in BST
       public static Node delete(Node root,int key){
           /**
             if we want to delete a node in BST do following steps:-
            1). Search the node in BST.
            2).Then Based on the case make the deletion, Cases are:-

            CASE 1). Node has no child(leaf node).   return null to its parent.
            CASE 2). Node has one child.         delete that node replace its position with its children node
            CASE 3). Node has two childs.  replace the nodes value with it inorder sucessor the delete that inorder
            sucessor node. (Inorder sucessor it the leftmost node of the right subtree.)
            */
               if (root == null) {
                   return null;
               }

               if (key < root.data) {
                   root.left = delete(root.left, key);  // Assign result back to root.left
               } else if (key > root.data) {
                   root.right = delete(root.right, key);  // Assign result back to root.right
               } else {
                   // CASE 1: Node with no child (leaf node)
                   if (root.left == null && root.right == null) {
                       return null;
                   }
                   // CASE 2: Node with one child
                   if (root.left == null) {
                       return root.right;
                   } else if (root.right == null) {
                       return root.left;
                   }
                   // CASE 3: Node with two children
                   Node inorderSuccessor = inSuccessor(root.right);  // root.right kyuki inorder sucessor right subtree me hoga
                   root.data = inorderSuccessor.data;  // Replace value with inorder successor
                   root.right = delete(root.right, inorderSuccessor.data);  // Delete the inorder successor
               }

               return root;
           }

           public static Node inSuccessor(Node root){
        while(root.left!=null){         // finding the leftmost node
            root = root.left;
        }
        return root;
       }

       // Print in Range
     public static void inRange(Node root,int min,int max){

         /**

          There are three cases:-

          CASE 1). if  k1(min) <=root<= k2(max) then look in both left subtree and right subtree
          CASE 2). if root < min  then look at right subtree
          CASE 3). if root => min  then look at left subtree
          */
         if(root==null){
            return;
        }
        if(min<=root.data && root.data<=max){
            inRange(root.left,min,max);
            System.out.print(root.data +" ");
            inRange(root.right,min,max);
        }
        else if(root.data<min){
            inRange(root.right,min,max);
        }
        else{
            inRange(root.left,min,max);
        }
     }

     // Print all path from root to leaf nodes
    public static void paths(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null) {   // Means ham leaf node me pahuch gaye the print the path
            printPaths(path);
        }
        else {
            paths(root.left, path);
            paths(root.right, path);
            path.remove(path.size() - 1);  // ek bar leaf tak pahuch jaye fir backtrack and remove the last elements
            // from arraylist till we got a node where other path is possible
        }
    }

    public static void printPaths(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("NULL");
    }

    // Traversal
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        ArrayList<Integer> path = new ArrayList<>();
        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insertVal(root,values[i]);
        }
        inOrder(root);
        System.out.println();
        if(search(root,7)){
            System.out.println("Element Found");
        }
        else{
            System.out.println("Element Not Found");
        }
        System.out.println("after deletion of 4");
        delete(root,4);
        inOrder(root);
        System.out.println();
        System.out.println("All the Elements from range 1 to 5");
        inRange(root,1,5);
        System.out.println();
        System.out.println("Printing all the paths from root to leaf:- ");
        paths(root,path);
    }
}
