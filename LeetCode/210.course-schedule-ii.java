import java.util.*;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0){
            int[] ret = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                ret[i] = i;
            }
            return ret;
        }
        // c.c.
        List<Integer> res = new LinkedList<>();
        Boolean[] visited = new Boolean[numCourses + 1];
        for(int[] edge: prerequisites) {
            if (dfs(edge[1], prerequisites, visited, res)) {
                return new int[]{};
            }
        }
        for (int i = 0; i < numCourses;i++){
            if (visited[i] == null) {
                res.add(i);
            }
        }
        int[] arrayResult = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            arrayResult[i] = res.get(i);
        }
        return arrayResult;
    }

    private boolean dfs(int cur, int[][] graph, Boolean[] visited, List<Integer> res) {
        if (visited[cur] != null) {
            return visited[cur];
        }
        visited[cur] = true;
        for(int[] edge: graph) {
            if (edge[1] == cur) {
                if(dfs(edge[0], graph, visited, res)) {
                    return true;
                }
            }
        }
        visited[cur] = false;
        res.add(0, cur);
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findOrder(3, new int[][]{{1,0}}));
    }

}
// @lc code=end

