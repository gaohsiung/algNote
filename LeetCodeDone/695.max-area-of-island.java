/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return max;
        }
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                int curSize = dfs(grid, i, j);
                max = Math.max(max, curSize);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        int curSize = 1;
        grid[i][j] = 0;
        for(int[] dir: DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] != 0) {
                curSize += dfs(grid, ii, jj);
            }
        }
        return curSize;
    }
}
// @lc code=end

