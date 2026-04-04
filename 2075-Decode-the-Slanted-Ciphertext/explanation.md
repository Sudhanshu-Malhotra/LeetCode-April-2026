# 2075. Decode the Slanted Ciphertext

## 🔗 Problem Link
https://leetcode.com/problems/decode-the-slanted-ciphertext/

---

## 💡 Intuition

The encoded string is formed by writing the original text diagonally in a matrix.

To decode:
1. First reconstruct the matrix row-wise.
2. Then read the matrix diagonally (top-left → bottom-right).
3. Remove trailing spaces.

---

## 🧠 Approach

- Compute number of columns = length / rows
- Fill a 2D matrix row by row
- Traverse diagonals starting from each column in the first row
- Append characters to result
- Trim trailing spaces

---

## 🧪 Dry Run

Input:
encodedText = "ch   ie   pr"
rows = 3

Matrix:
c h ' '
' ' i e
' ' ' ' p r

Diagonal traversal:
c → i → p  
h → e → r  

Result: "cipher"

---

## ⏱ Complexity

- Time: O(n)
- Space: O(n)

---

## 🚀 Optimization Idea

We can avoid using a matrix and directly calculate indices using:

index = i * cols + j

This reduces space usage.
