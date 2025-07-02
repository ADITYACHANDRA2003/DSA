package placement;

public class wordBreakProblem {

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

    // O(L) where L is the length of the longest word
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
    public static boolean Search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static boolean wordBreak(String key) {

        if(key.length() == 0)
            return true;

        for (int level = 1; level <=key.length(); level++) {
            if(Search(key.substring(0,level)) && wordBreak(key.substring(level)))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {

        String[] words = {"the","a","there","their","any","three"};
        for(int i=0; i<words.length; i++){
            Insert(words[i]);
        }
        String str1 = "athree";
        String str2 = "thetheirthere";
        String str3 = "athumb";
        System.out.println(wordBreak(str1));
        System.out.println(wordBreak(str2));
        System.out.println(wordBreak(str3));
    }
}
