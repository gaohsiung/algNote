import java.util.*;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        // c.c.
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && (!visited.contains(i*col+j))) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, Set<Integer> visited) {
        int row = grid.length;
        int col = grid[0].length;
        int index = i * col + j;
        visited.add(index);
        for(int[] dir: DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < row && jj >= 0 && jj < col 
                && (!visited.contains(ii*col+jj)) && grid[ii][jj] == '1') {
                dfs(grid, ii, jj, visited);
            }
        }

    }
}
// @lc code=end

