import java.util.*;
/*
 * @lc app=leetcode id=1466 lang=java
 *
 * [1466] Reorder Routes to Make All Paths Lead to the City Zero
 */

// @lc code=start
class Solution {
    
    public int minReorder(int n, int[][] connections) {
        if (connections == null || connections.length == 0 || connections[0] == null 
        || connections[0].length == 0 || n <= 0 || n - 1 != connections.length) {
            return 0;
        }
        // build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> reverseGraph = new HashMap<>();
        for (int[] edge: connections) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashSet<>());
            }
            if (!reverseGraph.containsKey(edge[1])) {
                reverseGraph.put(edge[1], new HashSet<>());
            }
            graph.get(edge[0]).add(edge[1]);
            reverseGraph.get(edge[1]).add(edge[0]);
        }
        // counts
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                int cur = queue.poll();
                if (reverseGraph.containsKey(cur)) {
                    for (int v: reverseGraph.get(cur)) {
                        queue.offer(v);
                        graph.get(v).remove(cur);
                    }
                    reverseGraph.remove(cur);
                }
                if (graph.containsKey(cur)) {
                    for (int v: graph.get(cur)) {
                        queue.offer(v);
                        reverseGraph.get(v).remove(cur);
                        count++;
                    }
                    graph.remove(cur);
                }
            }
        }
        return count;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minReorder(6, new int[][]{{0,1}, {1,3}, {2,3}, {4,0},{4,5}}));
    }
}
// @lc code=end

