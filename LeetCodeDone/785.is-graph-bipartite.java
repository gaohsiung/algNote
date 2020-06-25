import java.util.*;


/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0 && colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                colors[i] = 1;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int n: graph[cur]) {
                        if (colors[n] == 0) {
                            if (colors[cur] == 1) {
                                colors[n] = 2;
                            } else {
                                colors[n] = 1;
                            }
                            q.offer(n);
                        } else {
                            if (colors[cur] == colors[n]) {
                                return false;
                            }
                        }

                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

