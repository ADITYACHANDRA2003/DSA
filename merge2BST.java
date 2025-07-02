package placement;

import java.util.ArrayList;

public class merge2BST {
    public static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void inorder(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }

    public static ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int i=0 ,j=0;
        ArrayList res = new ArrayList();
        while(i<list1.size() && j<list2.size()) {
            if(list1.get(i)<list2.get(j)) {
                res.add(list1.get(i));
                i++;
            }
            else{
                res.add(list2.get(j));
                j++;
            }
        }
        while(i<list1.size()) {
            res.add(list1.get(i));
            i++;
        }
        while(j<list2.size()) {
            res.add(list2.get(j));
            j++;
        }
        return res;
    }
    public static Node validBST(ArrayList<Integer> list,int first,int last) {
        if(first>last) {
            return null;
        }
        int mid = first + (last-first)/2;
        Node root = new Node(list.get(mid));
        root.left = validBST(list,first,mid-1);
        root.right = validBST(list,mid+1,last);
        return root;
    }

    public static Node merge(Node root1, Node root2) {
        ArrayList<Integer> list1 =  new ArrayList<>();
        inorder(root1,list1);
        ArrayList<Integer> list2 =  new ArrayList<>();
        inorder(root2,list2);
        ArrayList<Integer> res = mergeList(list1,list2);
        Node root = validBST(res,0,res.size()-1);
        return root;
    }

    // Print inorder traversal of the merged BST
    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] one = {1,2,4};
        int[] two = {3,9,12};
        Node root1 = new Node(one[1]);
        root1.left = new Node(one[0]);
        root1.right = new Node(one[2]);

        Node root2 = new Node(two[1]);
        root2.left = new Node(two[0]);
        root2.right = new Node(two[2]);

        Node root = merge(root1,root2);
        System.out.println("The merged BST is :- ");
        printInorder(root);
    }
}