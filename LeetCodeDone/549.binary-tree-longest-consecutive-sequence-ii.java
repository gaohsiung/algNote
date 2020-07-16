/*
 * @lc app=leetcode id=549 lang=java
 *
 * [549] Binary Tree Longest Consecutive Sequence II
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
    private int longest = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return longest;
        }
        dfs(root);
        return longest;
    }

    private int[] dfs(TreeNode root) { // return int[longest -1, longest +1]
        if(root == null) {
            return null;
        }
        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        int[] rootRes = new int[2];
        rootRes[0] = 1;
        rootRes[1] = 1;
        if (root.left != null) {
            if (root.left.val + 1 == root.val) {
                rootRes[0] += leftRes[0];
            } else if (root.left.val - 1 == root.val) {
                rootRes[1] += leftRes[1];
            }
        }
        if (root.right != null) {
            if (root.right.val + 1 == root.val) {
                rootRes[0] = Math.max(rootRes[0], 1 + rightRes[0]);
            } else if (root.right.val - 1 == root.val) {
                rootRes[1] = Math.max(rootRes[1], 1 + rightRes[1]);
            }
        }
        longest = Math.max(longest, rootRes[0] + rootRes[1] - 1);
        return rootRes;
    }
}
// @lc code=end

