import java.util.*;

/*
 * @lc app=leetcode id=317 lang=java
 *
 * [317] Shortest Distance from All Buildings
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, cost, i, j);
                }
            }
        }
        int max = Integer.MAX_VALUE;
        for (int i  = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0){
                    max = Math.min(max, cost[i][j]);
                }
            }
        }
        return max == Integer.MAX_VALUE ? -1: max;

    }

    private void bfs(int[][] grid, int[][] cost, int startRow, int startCol) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startRow * col + startCol);
        boolean[][] visited = new boolean[row][col];
        int minLen = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int cur = q.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col 
                        && grid[ii][jj] == 0 && visited[ii][jj] == false) {
                        visited[ii][jj] = true;
                        cost[ii][jj] += minLen;
                        q.offer(ii*col + jj);
                    }
                }
            }
            minLen++;
        }
        for (int i = 0; i < row; i++) { // check if there is any dead 0s surrounded by 2
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && visited[i][j] == false) {
                    grid[i][j] = 2;
                }
            }
        }
        
    }
}
// @lc code=end

