import java.util.*;
/*
 * @lc app=leetcode id=1293 lang=java
 *
 * [1293] Shortest Path in a Grid with Obstacles Elimination
 */

// @lc code=start
class Solution { // O(row * col * k)
  private static final int[][] DIRECTION = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public int shortestPath(int[][] grid, int k) {
    // c.c.
    int minLen = 0;
    int row = grid.length;
    int col = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][][] visited = new boolean[row][col][k+1];
    queue.offer(new int[]{0, 0, 0});
    visited[0][0][0] = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] cur = queue.poll();
        int r = cur[0];
        int c = cur[1];
        if (r == row - 1 && c == col - 1) {
          return minLen;
        }
        int curDelNo = cur[2];
        for (int[] dir: DIRECTION) {
          int nextr = r + dir[0];
          int nextc = c + dir[1];
          if (nextr < 0 || nextr >= row || nextc < 0 || nextc >= col) {
            continue;
          }
          int nextDelNo = curDelNo + grid[nextr][nextc];
          if (nextDelNo > k || visited[nextr][nextc][nextDelNo]) {
            continue;
          }
          queue.offer(new int[]{nextr, nextc, nextDelNo});
          visited[nextr][nextc][nextDelNo] = true;
        }
      }
      minLen++;
    }
    return -1;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.shortestPath(new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}}, 1);
  }
}
// @lc code=end
