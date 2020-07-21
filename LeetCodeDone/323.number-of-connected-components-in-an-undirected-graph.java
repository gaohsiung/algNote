/*
 * @lc app=leetcode id=323 lang=java
 *
 * [323] Number of Connected Components in an Undirected Graph
 */

// @lc code=start
class Solution {
    private class UnionFind {
        int[] dads;
        int[] size;
        int counts;
        UnionFind(int n) {
            this.dads = new int[n];
            this.size = new int[n];
            this.counts = n;
            for(int i = 0; i < n; i++) {
                this.dads[i] = i;
                this.size[i] = 1;
            }
        }

        int getCounts() {
            return this.counts;
        }

        public boolean find(int n1, int n2) {
            return getRoot(n1) == getRoot(n2);
        }

        private int getRoot(int n) {
            int cur = n;
            while(dads[cur] != cur) {
                dads[cur] = dads[dads[cur]];
                cur = dads[cur];
            }
            dads[n] = cur;
            return cur;
        }

        public void union(int n1, int n2) {
            int root1 = getRoot(n1);
            int root2 = getRoot(n2);
            if (size[root1] > size[root2]) {
                dads[root2] = root1;
                size[root1] += size[root2];
            } else {
                dads[root1] = root2;
                size[root2] += size[root1];
            }
            this.counts--;
        }

    }
    public int countComponents(int n, int[][] edges) {
        if (n < 0) return 0;

        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if(!uf.find(n1, n2)) {
                uf.union(n1, n2);
            }
        }
        return uf.getCounts();
    }
}
// @lc code=end

