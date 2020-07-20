/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
    private static class UnionFind {
        int[] parents;
        int[] size;
        UnionFind(int n) {
            this.parents = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++) {
                this.parents[i] = i;
                this.size[i] = 1;
            }
        }
        boolean find(int n1, int n2) {
            return getRoot(n1) == getRoot(n2);
        }

        private int getRoot(int n) {
            int cur = n;
            while(this.parents[cur] != cur) {
                this.parents[cur] = this.parents[this.parents[cur]];
                cur = this.parents[cur];
            }
            this.parents[n] = cur;
            return cur;
        }

        public void union(int n1, int n2) {
            int root1 = getRoot(n1);
            int root2 = getRoot(n2);
            if(this.size[root1] > this.size[root2]) {
                this.parents[root2] = root1;
                this.size[root1] += this.size[root2];
            } else {
                this.parents[root1] = root2;
                this.size[root2] += this.size[root1];
            }
        }


    }
    public boolean validTree(int n, int[][] edges) {
        if(n != edges.length + 1) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges) {
            if(!uf.find(edge[0], edge[1])) {
                uf.union(edge[0], edge[1]);
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.validTree(5, new int[][]{{0,1},{0,4},{1,4},{2,3}}));
    }
}
// @lc code=end

