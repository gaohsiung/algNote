import java.util.Stack;

/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        Stack<TreeNode> stack = new Stack<>();
        int diff = Integer.MAX_VALUE;
        TreeNode cur = root;
        Integer prev = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (prev == null) {
                    prev = cur.val;
                } else {
                    diff = Math.min(diff, Math.abs(cur.val - prev));
                    prev = cur.val;
                }
                cur = cur.right;
            }
        }
        return diff;
    }
}
// @lc code=end

