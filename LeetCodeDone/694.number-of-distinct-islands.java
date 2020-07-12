import java.util.*;

/*
 * @lc app=leetcode id=694 lang=java
 *
 * [694] Number of Distinct Islands
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        Set<String> checkDups = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                StringBuilder path = new StringBuilder();
                dfs(grid, i, j, path, "o");
                checkDups.add(path.toString());
            }
        }
        return checkDups.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder path, String s) {
        grid[i][j] = 0;
        path.append(s);
        for(int d = 0; d < DIRECTIONS.length; d++) {
            int ii = i + DIRECTIONS[d][0];
            int jj = j + DIRECTIONS[d][1];
            if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] != 0) {
                dfs(grid, ii, jj, path, String.valueOf(d));
            }
            path.append("b");
        }
    }
}
// @lc code=end

