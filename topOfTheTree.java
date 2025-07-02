package placement;

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class topOfTheTree {
    // Object for node creation
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

    // Building binary tree
    public static Node buildBinaryTree(int[] nodes, int[] idx) {
        if (idx[0] >= nodes.length || nodes[idx[0]] == -1) {
            idx[0]++;
            return null;
        }
        Node newNode = new Node(nodes[idx[0]++]);
        newNode.left = buildBinaryTree(nodes, idx);
        newNode.right = buildBinaryTree(nodes, idx);
        return newNode;
    }

    public static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        if (root == null) return;

        // Level Order Traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> hm = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.poll();

            // If hd is encountered for the first time, store it
            if (!hm.containsKey(curr.hd)) {
                hm.put(curr.hd, curr.node);
            }

            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }

            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }

        // Print top view
        for (int i = min; i <= max; i++) {
            System.out.print(hm.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        int tree[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        /**
                1
              /   \
             2     3
           /   \     \
         4     5     6
         */

        int[] idx = {0};  // Using array to track index
        Node root = buildBinaryTree(tree, idx);
        topView(root);
    }
}
