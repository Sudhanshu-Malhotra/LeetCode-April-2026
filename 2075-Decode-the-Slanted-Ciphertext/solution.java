/*
Problem: 2075. Decode the Slanted Ciphertext
Link: https://leetcode.com/problems/decode-the-slanted-ciphertext/
Difficulty: Medium

Approach:
- Fill matrix row-wise using given encoded text
- Traverse diagonally starting from each column
- Append characters and remove trailing spaces

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int col = encodedText.length() / rows;
        char[][] matrix = new char[rows][col];

        int i = 0, j = 0;

        // Fill matrix row-wise
        for (int idx = 0; idx < encodedText.length(); idx++) {
            matrix[i][j] = encodedText.charAt(idx);

            if (j < col - 1) j++;
            else {
                i++;
                j = 0;
            }
        }

        StringBuilder s = new StringBuilder();

        // Traverse diagonally
        for (j = 0; j < col; j++) {
            for (i = 0; i < rows; i++) {
                if (j + i < col) {
                    s.append(matrix[i][j + i]);
                }
            }
        }

        return s.toString().stripTrailing();
    }
}
