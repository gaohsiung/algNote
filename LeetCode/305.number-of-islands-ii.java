import java.util.*;

/*
 * @lc app=leetcode id=305 lang=java
 *
 * [305] Number of Islands II
 */

// @lc code=start
class Solution {
    private class UnionFind {
        int[] parents;
        int[] size;
        int islandNum;
        UnionFind(int m, int n) {
            parents = new int[m*n];
            size = new int[m*n];
            islandNum = 0;
        }
        int getRoot(int node) {
            int cur = node;
            while(parents[cur] != cur) {
                parents[cur] = parents[parents[cur]];
                cur = parents[cur];
            }
            parents[node] = cur;
            return cur;
        }
        boolean find(int node1, int node2) {
            return getRoot(node1) == getRoot(node2);
        }
        void union(int node1, int node2) {
            int root1 = getRoot(node1);
            int root2 = getRoot(node2);
            if(size[root1] > size[root2]) {
                parents[root2] = root1;
                size[root1] += size[root2];
            } else {
                parents[root1] = root2;
                size[root2] += size[root1];
            }
            islandNum--;
        }

        void addNode(int node) {
            parents[node] = node;
            size[node] = 1;
            islandNum++;
        }
        boolean containsNode(int node) {
            return size[node] > 0;
        }
        int getIslandNum() {
            return islandNum;
        }
        
    }

    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new LinkedList<>();
        UnionFind uf = new UnionFind(m, n);
        for(int[] pos: positions) {
            if (pos[0] < 0 || pos[0] >= m || pos[1] < 0 || pos[1] >= n) continue;
            int index = pos[0]*n+pos[1];
            if (!uf.containsNode(index)) {
                uf.addNode(pos[0]*n+pos[1]);
            }
            for (int[] dir: DIRECTIONS) {
                int ii = pos[0] + dir[0];
                int jj = pos[1] + dir[1];
                int nei = ii * n + jj;
                if (ii >= 0 && ii < m && jj >= 0 && jj < n && uf.containsNode(nei)) {
                    if (!uf.find(index, nei)) {
                        uf.union(index, nei);
                    }
                }
            }
            res.add(uf.getIslandNum());
        }
        return res;
    }
    public static void main(String[] arags) {
        Solution sol = new Solution();
        System.out.println(sol.numIslands2(3, 3, new int[][]{{0,1},{0,0},{1,2},{1,2}}));
    }
}
// @lc code=end

