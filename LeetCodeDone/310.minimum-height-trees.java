import java.util.*;

import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    class GraphNode{
        int val;
        Set<GraphNode> neighs;

        GraphNode(int val) {
            this.val = val;
            neighs = new HashSet<>();
        }

        boolean isLeave() {
            return neighs.size() == 1;
        }

        void addNeigh(GraphNode n1) {
            neighs.add(n1);
        }

        void removeNeigh(GraphNode n1) {
            neighs.remove(n1);
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new LinkedList<>();
        // c.c.
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add(0);
            return res;
        }
        //build graph
        GraphNode[] graphNodes = new GraphNode[n];
        for (int i = 0; i < n;i++) {
            graphNodes[i] = new GraphNode(i);
        }
        for(int[] pair: edges) {
            graphNodes[pair[0]].addNeigh(graphNodes[pair[1]]);
            graphNodes[pair[1]].addNeigh(graphNodes[pair[0]]);
        }
        //find leaves and put into queue
        int count = n;
        Queue<GraphNode> q = new LinkedList<>();
        for(GraphNode gn: graphNodes) {
            if (gn.isLeave()) {
                q.add(gn);
                count--;
            }
        }
        //bfs remove leaves
        while(count > 0) {
            int size = q.size();
            while(size-- > 0) {
                GraphNode cur = q.poll();
                for(GraphNode gn: cur.neighs) {
                    gn.neighs.remove(cur);
                    if(gn.isLeave()) {
                        q.offer(gn);
                        count--;
                    }
                }
            }
        }
        //add to res
        while(!q.isEmpty()) {
            res.add(q.poll().val);
        }
        return res;

    }
}
// @lc code=end

