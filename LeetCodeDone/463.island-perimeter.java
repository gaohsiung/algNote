/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int islandPerimeter(int[][] grid) {
        // c.c.

        int ret = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii == -1 || ii == row || jj == -1 || jj == col || grid[ii][jj] == 0) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
}
// @lc code=end

