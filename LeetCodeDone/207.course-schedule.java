import java.util.*;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // c.c.

        Boolean[] visited = new Boolean[numCourses + 1];
        for(int[] edge: prerequisites) {
            if (dfs(prerequisites, edge[1], visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] prerequisites, int cur, Boolean[] visited) {
        if(visited[cur] != null) { // visited, not cycle
            return visited[cur];
        }
        visited[cur] = true; // visiting ...
        for(int[] edge: prerequisites) {
            if(edge[1] == cur) {
                if (dfs(prerequisites, edge[0], visited)) {
                    return true;
                }
            }
        }
        visited[cur] = false; // visited, no cycle
 
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canFinish(2, new int[][]{{1, 0}}));
    }
}
// @lc code=end

