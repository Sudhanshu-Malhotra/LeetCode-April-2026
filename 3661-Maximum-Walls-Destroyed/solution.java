/*
Problem: Maximum Walls Destroyed by Robots
Link: https://leetcode.com/problems/decode-the-slanted-ciphertext
Difficulty: Hard

Approach:
- Sort robots by position and walls array.
- Maintain two pointers (left robot and right robot) around each wall.
- Use DP with 4 states:
    LL: both walls assigned to left robot
    LR: left -> left robot, right -> right robot
    RL: right -> left robot, left -> right robot
    RR: both assigned to right robot

- For each wall:
    1. Shift robot pointers if wall passes current right robot.
    2. Check reachability:
        - Left robot can hit if wall <= (pos + distance)
        - Right robot can hit if wall >= (pos - distance)
    3. Update DP states accordingly.

Time Complexity: O(n log n + m log m)
Space Complexity: O(1)
*/

import java.util.*;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        int r[][] = new int[n + 2][2];
        for (int i = 0; i < n; i++) {
            r[i][0] = robots[i];
            r[i][1] = distance[i];
        }

        // Sentinel robots
        r[n][0] = -1;
        r[n][1] = 0;
        r[n + 1][0] = Integer.MAX_VALUE;
        r[n + 1][1] = 0;

        Arrays.sort(r, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(walls);

        int LL = 0, LR = 1, RL = 2, RR = 3;
        int dp[] = new int[4];

        int leftrobot = 0, rightrobot = 1;

        for (int wall : walls) {

            while (wall > r[rightrobot][0]) {
                leftrobot++;
                rightrobot++;

                int maxL = Math.max(dp[LL], dp[RL]);
                int maxR = Math.max(dp[LR], dp[RR]);

                dp[LL] = maxL;
                dp[LR] = maxL;

                dp[RL] = maxR;
                dp[RR] = maxR;
            }

            int r1reach = r[leftrobot][0] + r[leftrobot][1];
            int r2reach = r[rightrobot][0] - r[rightrobot][1];

            boolean canR1 = wall <= r1reach;
            boolean canR2 = wall >= r2reach;
            boolean isRightPoint = wall == r[rightrobot][0];

            if (canR2) dp[LL]++;
            if (isRightPoint) dp[LR]++;
            if (canR1 || canR2) dp[RL]++;
            if (canR1 || isRightPoint) dp[RR]++;
        }

        int ans = 0;
        for (int v : dp) ans = Math.max(ans, v);

        return ans;
    }
}
