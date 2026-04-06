import java.util.HashSet;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> hset = new HashSet<>();

        // Store obstacles as "x#y"
        for (int[] ob : obstacles) {
            hset.add(ob[0] + "#" + ob[1]);
        }

        int x = 0, y = 0;

        // Directions: North, East, South, West
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int position = 0; // 0=N, 1=E, 2=S, 3=W

        int maxDist = 0;

        for (int command : commands) {

            if (command == -1) { // turn right
                position = (position + 1) % 4;
            } 
            else if (command == -2) { // turn left
                position = (position + 3) % 4;
            } 
            else {
                // move step by step
                for (int i = 0; i < command; i++) {
                    int nextX = x + dir[position][0];
                    int nextY = y + dir[position][1];

                    if (hset.contains(nextX + "#" + nextY)) {
                        break; // obstacle found
                    }

                    x = nextX;
                    y = nextY;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}
