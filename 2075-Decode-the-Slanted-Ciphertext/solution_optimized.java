/*
Problem: 2075. Decode the Slanted Ciphertext
Link: https://leetcode.com/problems/decode-the-slanted-ciphertext/
Difficulty: Medium

Optimized Approach:
- No need to build a matrix
- Treat string as virtual matrix
- Index formula: i * cols + j
- Traverse diagonally using this mapping

Time Complexity: O(n)
Space Complexity: O(1) (excluding output)
*/

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder res = new StringBuilder();

        // Start from each column
        for (int j = 0; j < cols; j++) {
            int i = 0, k = j;

            // Move diagonally
            while (i < rows && k < cols) {
                res.append(encodedText.charAt(i * cols + k));
                i++;
                k++;
            }
        }

        return res.toString().stripTrailing();
    }
}
