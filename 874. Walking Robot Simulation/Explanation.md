# Walking Robot Simulation (LeetCode 874)

## Problem Statement

A robot starts at position `(0, 0)` on an infinite 2D plane, initially facing **North**.

The robot is given a sequence of commands:

- `-2`: Turn left by 90°
- `-1`: Turn right by 90°
- `1 ≤ k ≤ 9`: Move forward `k` steps (one unit at a time)

Some grid positions contain obstacles. If the robot encounters an obstacle, it:
- Stops before the obstacle
- Continues with the next command

### Goal
Return the **maximum squared Euclidean distance** from the origin `(0,0)` that the robot reaches at any point.

---

## Important Notes

- Obstacles are given as `obstacles[i] = (xi, yi)`
- The robot **cannot enter obstacle cells**
- If `(0,0)` is an obstacle:
  - Robot can start there
  - But cannot return once it leaves
- Directions:
  - North → +Y
  - East → +X
  - South → -Y
  - West → -X

---

## Approach

### 1. Efficient Obstacle Lookup

We store all obstacle coordinates in a `HashSet` using a unique string format:
"x#y"


This allows **O(1)** time complexity for obstacle checks.

---

### 2. Direction Handling

We represent directions using an index and movement vectors:

| Direction | Index | Movement |
|----------|------|----------|
| North    | 0    | (0, +1)  |
| East     | 1    | (+1, 0)  |
| South    | 2    | (0, -1)  |
| West     | 3    | (-1, 0)  |

Direction updates:
- Turn right → `(dir + 1) % 4`
- Turn left → `(dir + 3) % 4`

---

### 3. Step-by-Step Simulation

For forward movement:
- Move **one step at a time**
- Before moving, check if next position is an obstacle
- If blocked → stop movement for that command

This ensures accurate obstacle handling.

---

### 4. Distance Calculation

After every valid step:

distance = x² + y²

