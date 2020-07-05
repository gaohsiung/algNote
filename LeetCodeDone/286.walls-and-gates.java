import java.util.*;

/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms.length == 0) {
            return;
        }
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(col*i + j);
                }    
            }
        }
        int minLen = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int temp = 0; temp < size; temp++) {
                int cur = q.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if(ii >= 0 && ii < row && jj >= 0 && jj < col && rooms[ii][jj] == Integer.MAX_VALUE) {
                        q.offer(ii*col + jj);
                        rooms[ii][jj] = minLen;
                    }
                }
            }
            minLen++;
        }
        return;
    }
}
// @lc code=end
//----------------------------------------------------------------------------
//V: mn
//E: mn