package placement;

public class stringCompression {
    public static void main(String[] args) {
        String str = "aaabbbbccdee";
        StringBuilder str1 = new StringBuilder();
        int count = 1;  // Start count at 1 because we already have the first character

        for (int i = 0; i < str.length() - 1; i++) { // Loop till second last element
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++; // Increment count if the current character is the same as the next
            } else {
                str1.append(str.charAt(i)); // Append the current character
                str1.append(count);          // Append the count of the character
                count = 1;                   // Reset count for the next character
            }
        }

        // Handle the last character (after loop)
        str1.append(str.charAt(str.length() - 1)); // Append the last character
        str1.append(count); // Append its count

        System.out.println(str1); // Output the result
    }
}
