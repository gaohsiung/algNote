/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compareTwoSubHeight(root) != -1;
    }

    private int compareTwoSubHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = compareTwoSubHeight(root.left);
        int right = compareTwoSubHeight(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
// @lc code=end

