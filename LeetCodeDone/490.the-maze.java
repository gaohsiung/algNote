import java.util.*;
/*
 * @lc app=leetcode id=490 lang=java
 *
 * [490] The Maze
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] target) {
        // c.c.

        int col = maze[0].length;
        return dfs(maze, start[0]*col + start[1], target[0] * col + target[1], new HashSet<Integer>());
    }
    private boolean dfs(int[][] maze, int cur, int target, Set<Integer> visited) {
        if (cur == target) {
            return true;
        }
        if (visited.contains(cur)) {
            return false;
        }
        visited.add(cur);
        
        for (int dir: move(maze, cur)) {
            if (dfs(maze, dir, target, visited)) {
                return true;
            }
        }
        return false;
    }
    private int[] move(int[][] maze, int cur) {
        int[] res = new int[4];
        int row = maze.length;
        int col = maze[0].length;
        int i = cur / col;
        int j = cur % col;
        for (int dir = 0; dir < 4; dir++) {
            int ii = i;
            int jj = j;
            while (ii >= 0 && ii < row && jj >= 0 && jj < col && maze[ii][jj] == 0) {
                ii = ii + DIRECTIONS[dir][0];
                jj = jj + DIRECTIONS[dir][1];
            }
            res[dir] = (ii - DIRECTIONS[dir][0]) * col + (jj - DIRECTIONS[dir][1]);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hasPath(new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}}, new int[]{0,4}, new int[]{4,4}));
    }
}
// @lc code=end

