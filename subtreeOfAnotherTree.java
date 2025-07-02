package placement;

public class subtreeOfAnotherTree {
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

        public static boolean isIdentical(Node root1, Node root2){
            if(root1 == null && root2 == null){  // agar dono lost the pahuch jaye means identical
                return true;
            }
            if(root1 == null || root2 == null || root1.data != root2.data){ // agar koi ek unme se null hai
                return false;                                               // ya root data not equals subroot data
            }
            if(!isIdentical(root1.left, root2.left)){                       // agar dono ka left unequal hai
                return false;
            }
            if(!isIdentical(root1.right, root2.right)){                     // agar dono ka right unequal hai
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node root1, Node root2){
             if(root1 == null){
                 return false;
             }
                 if (isIdentical(root1, root2)) {
                     return true;
                 }
             return isSubtree(root1.left, root2) || isSubtree(root1.right, root2); // agar left ya right me pura
            // subtree mil jaye then return true
        }


        public static void main(String[] args) {
            int tree[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            /**
                     1
                   /  \
                  2    3
                 /  \    \
                4    5    6
             */

            Node maintree = buildBinaryTree(tree);

            idx = -1;  // reseting idx before creating another tree

            int[] subTree = {2,4,-1,-1,5,-1,-1};
            Node subtr = buildBinaryTree(subTree);

            if(isSubtree(maintree,subtr)){
                System.out.println("True");
            }
            else{
                System.out.println("False");
            }
        }
}
