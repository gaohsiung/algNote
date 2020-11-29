import java.util.*;

/*
 * @lc app=leetcode id=1368 lang=java
 *
 * [1368] Minimum Cost to Make at Least One Valid Path in a Grid
 */

// @lc code=start
class Solution {
  private static final int[][] DIRECTIONS = new int[][]{{0, 1},{0, -1}, {1, 0}, {-1,0}};
  public int minCost(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int[][] visited = new int[row][col];
    for (int[] arr: visited) {
      Arrays.fill(arr, -1);
    }
    Queue<Integer> queue = new ArrayDeque<>();
    int cost = 0;
    if (getGoal(grid, 0, 0, queue, visited, cost)) {
      return cost;
    }
    while (!queue.isEmpty()) {
      cost++;
      int size = queue.size();
      while (size-- > 0) {
        int cur = queue.poll();
        int r = cur / col;
        int c = cur % col;
        for (int [] dir: DIRECTIONS) {
          int rr = r + dir[0];
          int cc = c + dir[1];
          if (getGoal(grid, rr, cc, queue, visited, cost)) {
            return cost;
          }
        }
      }
    }
    return -1;
  }
  private boolean getGoal(int[][] grid, int r, int c, Queue<Integer> queue, int[][] visited, int cost) {
    int row = grid.length;
    int col = grid[0].length;
    if (r == row - 1 && c == col - 1) {
      return true;
    }
    if (!(r >= 0 && r < row && c >= 0 && c < col && visited[r][c] == -1)) {
      return false;
    }
    visited[r][c] = cost;
    queue.offer(r * col + c);
    int rr = r + DIRECTIONS[grid[r][c] - 1][0];
    int cc = c + DIRECTIONS[grid[r][c] - 1][1];
    
    return getGoal(grid, rr, cc, queue, visited, cost);
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.minCost(new int[][]{{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}});
  }

}
// @lc code=end
