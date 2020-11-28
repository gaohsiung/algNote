
/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
class Solution {
  private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
  public int closedIsland(int[][] grid) {
    // c.c.

    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if ((grid[i][j] == 0) && (dfs(grid, i, j, true))) {
          res++;
        }
      }
    }
    return res;
  }

  private boolean dfs(int[][] grid, int r, int c, boolean flag) {
    grid[r][c] = 1;
    int row = grid.length;
    int col = grid[0].length;
    for (int[] dir : DIRECTIONS) {
      int rr = r + dir[0];
      int cc = c + dir[1];
      if (rr < 0 || rr >= row || cc < 0 || cc >= col) {
        flag = false;
        continue;
      }
      if (grid[rr][cc] == 0 && (!dfs(grid, rr, cc, flag))) {
        flag = false;
      }
    }
    return flag;
  }
}
// @lc code=end
