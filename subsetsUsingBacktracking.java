package placement;

// O(n*2^n) !!
// SUBARRAY != SUBSET AS SUBARRAY IS CONTIGUOUS IN NATURE(ORDER MAINTAINED) BUT NOT SAME IN SUBSET
public class subsetsUsingBacktracking {
        public static void findSubsets(String str, StringBuilder ans, int i) {
            // Base case
            if (i == str.length()) {
                if(ans.toString().length()==0) System.out.print("null");
                else System.out.print(ans.toString()+" ");
                return;
            }

            // Yes choice: Include the current character
            ans.append(str.charAt(i));
            findSubsets(str, ans, i + 1);
            ans.deleteCharAt(ans.length() - 1); // Backtrack

            // No choice: Exclude the current character
            findSubsets(str, ans, i + 1);
        }

        public static void main(String[] args) {
            String str = "123";
            findSubsets(str, new StringBuilder(), 0);
        }

}
