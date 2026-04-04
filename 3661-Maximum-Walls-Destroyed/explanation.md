## Intuition

We process walls from left to right and maintain two robots:
- closest robot on left
- closest robot on right

Each wall can be destroyed by:
- left robot
- right robot
- both (depending on reach)

## Key Idea

Use 4 DP states to track assignments:
- LL, LR, RL, RR

We continuously update states while shifting robot window.

## Why it works

Sorting ensures we process in order, and DP ensures optimal assignment.
