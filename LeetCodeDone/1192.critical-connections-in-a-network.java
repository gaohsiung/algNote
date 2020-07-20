import java.util.*;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {

    private int ts = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // c.c.
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(List<Integer> conn: connections) {
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }
        List<List<Integer>> res = new LinkedList<>();
        int[] rs = new int[n];
        // for(List<Integer> edge: connections) {
        dfs(0, -1, rs, graph, res);
        // }
        return res;
    }

    private int dfs(Integer cur, int prev, int[] rs,
                    List<List<Integer>> graph, List<List<Integer>> res) {
        if (rs[cur] > 0) {
            return rs[cur];
        }
        ts++;
        rs[cur] = ts;
        int min = Integer.MAX_VALUE;
        for(int next: graph.get(cur)) {
            if(next == prev) continue;
            int ret = dfs( next, cur, rs, graph, res);
            min = Math.min(min, ret);
        }
        if(prev != -1  && rs[cur] <= min) {
            res.add(Arrays.asList(prev, cur));
        }
        return Math.min(rs[cur], min);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[][] array = new Integer[][]{{1,0},{2,0},{3,0},{4,1},{4,2},{4,0}};
        // Integer[][] array = new Integer[][]{{0,1},{1,2},{2,0},{1,3}};
        List<List<Integer>> list = new LinkedList<>();
        for(Integer[] a: array) {
            list.add(Arrays.asList(a));
        }
        
        System.out.println(sol.criticalConnections(5, list));
    }
}
// @lc code=end

// 无向图要使用cur:List<next> 转换！
