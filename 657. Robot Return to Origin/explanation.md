# 🚀 Robot Return to Origin (LeetCode 657)

## 🧠 Problem
A robot starts at position (0, 0) on a 2D plane.

You are given a string `moves` where:
- 'R' → move right
- 'L' → move left
- 'U' → move up
- 'D' → move down

Return `true` if the robot returns to the origin after all moves, otherwise return `false`.

---

## 💡 Approach

We track the robot’s position using two variables:
- `x` → horizontal position
- `y` → vertical position

### Movement Rules:
- 'R' → x++
- 'L' → x--
- 'U' → y++
- 'D' → y--

After processing all moves:
- If `x == 0` and `y == 0` → robot is back at origin ✅
- Else → not at origin ❌

---

## 🔍 Example

**Input:**
