/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 */

// @lc code=start
class Solution {
  private int res = 0;
  public int uniquePathsIII(int[][] grid) {
    int startR = -1;
    int startC = -1;
    int needToBeTraverse = 1;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) {
          startR = r;
          startC = c;
        } else if (grid[r][c] == 0) {
          needToBeTraverse++;
        }
      }
    }
    dfs(grid, startR, startC, needToBeTraverse);
    return res;
  }
  private void dfs(int[][] grid, int r, int c, int needToBeTraverse) {
    int row = grid.length;
    int col = grid[0].length;
    if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == -1) {
      return;
    }
    if (grid[r][c] == 2) {
      if (needToBeTraverse == 0) {
        res++;
      }
      return;
    }

    grid[r][c] = -1;
    dfs(grid, r-1, c, needToBeTraverse-1);
    dfs(grid, r+1, c, needToBeTraverse-1);
    dfs(grid, r, c-1, needToBeTraverse-1);
    dfs(grid, r, c+1, needToBeTraverse-1);
    grid[r][c] = 0;
    return;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
  }
}
// @lc code=end
