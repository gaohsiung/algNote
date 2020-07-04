/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (r == 0 && c == 0) {
                    continue;
                } else if (r == 0) {
                    grid[r][c] = grid[r][c] + grid[r][c-1];
                } else if (c == 0) {
                    grid[r][c] = grid[r][c] + grid[r-1][c];
                } else {
                    grid[r][c] = Math.min(grid[r][c-1], grid[r-1][c]) + grid[r][c];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
// @lc code=end

