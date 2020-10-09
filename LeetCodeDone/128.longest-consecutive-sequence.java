import java.util.*;
/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        // c.c.
        if (nums == null || nums.length == 0) return 0;

        UnionFind uf = new UnionFind(nums.length);
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (counts.containsKey(nums[i])) {
                continue;
            }
            counts.put(nums[i], i);
            if (counts.containsKey(nums[i] - 1)) {
                if (!uf.find(i, counts.get(nums[i] - 1))) {
                    uf.union(i, counts.get(nums[i] - 1));
                }
            }
            if (counts.containsKey(nums[i] + 1)) {
                if (!uf.find(i, counts.get(nums[i] + 1))) {
                    uf.union(i, counts.get(nums[i] + 1));
                }
            }
        }
        return uf.getMaxSize();
    }
    private class UnionFind {
        int[] parents;
        int[] sizeList;
        int maxSize;
        private UnionFind(int len) {
            parents = new int[len];
            sizeList = new int[len];
            for (int i = 0; i < len; i++) {
                parents[i] = i;
                sizeList[i] = 1;
            }
            maxSize = 1;
        }
        private int getRoot(int cur) {
            while (parents[cur] != cur) {
                parents[cur] = parents[parents[cur]];
                cur = parents[cur];
            }
            return cur;
        }
        private boolean find(int node1, int node2) {
            int root1 = getRoot(node1);
            int root2 = getRoot(node2);
            return root1 == root2;
        }
        private void union(int node1, int node2) {
            int root1 = getRoot(node1);
            int root2 = getRoot(node2);
            if (sizeList[root1] > sizeList[root2]) {
                parents[root2] = root1;
                sizeList[root1] += sizeList[root2];
                maxSize = Math.max(maxSize, sizeList[root1]);
            } else {
                parents[root1] = root2;
                sizeList[root2] += sizeList[root1];
                maxSize = Math.max(maxSize, sizeList[root2]);
            }
        }
        private int getMaxSize() {
            return maxSize;
        }

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(new int[]{1,0,-1}));
    }
}
// @lc code=end

