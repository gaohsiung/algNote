/*
 * @lc app=leetcode id=298 lang=java
 *
 * [298] Binary Tree Longest Consecutive Sequence
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
    private int count = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return count;
        
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftRes = dfs(root.left);
        int rightRes = dfs(root.right);
        int rootRes = 1;
        if (root.left != null && root.left.val == root.val + 1) {
            rootRes = leftRes + 1;
        }
        if (root.right != null && root.right.val == root.val + 1) {
            rootRes = Math.max(rootRes, rightRes + 1);
        }
        count = Math.max(count, rootRes);
        return rootRes;
    }
}
// @lc code=end

