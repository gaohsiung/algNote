import java.util.*;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, sum, map);
    }
    
    private int dfs(TreeNode root, int cur, int sum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        cur = cur + root.val;
        int ret = 0;
        if (map.containsKey(cur - sum)) {
            ret += map.get(cur - sum);
        }
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        ret = ret + dfs(root.left, cur, sum, map) + dfs(root.right, cur, sum, map);
        map.put(cur, map.get(cur) - 1);
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pathSum(new TreeNode(1), 0));
    }
}
// @lc code=end
//
// public int pathSum(TreeNode root, int sum) {
//     Map<Integer, Integer> prefixSumMap = new HashMap<>();
//     prefixSumMap.put(0, 1);
//     return dfs(root, sum, 0, prefixSumMap);
// }

// private int dfs(TreeNode root, int sum, int cur, Map<Integer, Integer> prefixSumMap) {
//     if (root == null) {
//         return 0;
//     }
//     cur = cur + root.val;
//     int ret = 0;
//     if (prefixSumMap.containsKey(cur - sum)) {
//         ret += prefixSumMap.get(cur - sum);
//     }
//     prefixSumMap.put(cur, prefixSumMap.getOrDefault(cur, 0) + 1);
//     ret += dfs(root.left, sum, cur, prefixSumMap) + dfs(root.right, sum, cur, prefixSumMap);
//     prefixSumMap.put(cur, prefixSumMap.get(cur)-1);
//     return ret;
// }
