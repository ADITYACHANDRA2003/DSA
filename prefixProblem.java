package placement;

public class prefixProblem {

    // Trie Node structure
    public static class Node {
        Node[] children = new Node[26]; // Array to store references to child nodes (26 letters in English)
        boolean eow = false; // End of Word marker to indicate the completion of a word
        int freq; // Frequency counter to track how many words pass through this node

        // Constructor to initialize a new Trie Node
        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null; // Initialize all children as null
            }
            freq = 1; // Default frequency is 1 when a new node is created
        }
    }

    // Root node of the Trie
    public static Node root = new Node();

    // Method to insert a word into the Trie
    public static void Insert(String word) {
        Node curr = root; // Start from the root node

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a'; // Convert character to index (0-25)

            // If the corresponding child node does not exist, create it
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++; // If it exists, increase frequency count
            }

            // Move to the next node
            curr = curr.children[idx];
        }

        // Mark the last node as the end of a valid word
        curr.eow = true;
    }

    // Method to find and print the unique prefix for each word
    public static void findPrefix(Node root, String ans) {
        // Base condition: If root is null, return (no need to process further)
        if (root == null) return;

        // If frequency of a node is 1, it means this is a unique prefix
        if (root.freq == 1) {
            System.out.println(ans); // Print the unique prefix
            return;
        }

        // Traverse all possible children (letters 'a' to 'z')
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) { // If the child node exists
                // Recursive call with updated prefix string
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    // Main function to insert words and find unique prefixes
    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"}; // List of words to insert in Trie

        // Insert all words into the Trie
        for (int i = 0; i < arr.length; i++) {
            Insert(arr[i]);
        }

        // Set the root node frequency to -1 to avoid confusion
        root.freq = -1;

        // Call function to find unique prefixes for inserted words
        findPrefix(root, "");
    }
}
