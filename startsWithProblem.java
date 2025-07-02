package placement;

public class startsWithProblem {

    public static class Node{
        Node[] children = new Node[26];
        boolean eow;

        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    static Node root = new Node();


    public static void Insert(String word) {
        // Start from the root node of the Trie
        Node curr = root;

        // Loop through each character in the word
        for (int level = 0; level < word.length(); level++) {
            // Convert the character to an index (0-25) based on 'a' to 'z'
            int idx = word.charAt(level) - 'a';

            // If there is no node for this character, create a new node
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // Move to the next node
            curr = curr.children[idx];
        }

        // Mark the last node as the end of a valid word
        curr.eow = true;
    }

    // O(L)
    public static boolean startsWith(String key) {
      Node curr = root;
      for (int level = 0; level < key.length(); level++) {
          int idx = key.charAt(level) - 'a';
          if (curr.children[idx] == null) {  // we seached for the character in string and if not a valid character
              return false;                 // is found return false
          }
          curr = curr.children[idx];
      }
      return true;
    }


    public static void main(String[] args) {

        String[] words = {"the", "a", "there", "their", "any", "three"};
        for (int i = 0; i < words.length; i++) {
            Insert(words[i]);
        }
        System.out.println(startsWith("th"));
        System.out.println(startsWith("te"));
        System.out.println(startsWith("test"));
        System.out.println(startsWith("an"));
    }

}
