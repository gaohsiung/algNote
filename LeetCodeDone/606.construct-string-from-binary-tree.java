/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        String leftStr = tree2str(root.left);
        String rightStr = tree2str(root.right);
        if (leftStr.equals("") && rightStr.equals("")) {
            return Integer.toString(root.val);
        } else if (leftStr.equals("")) {
            return Integer.toString(root.val)+"()"+"("+rightStr+")";
        } else if (rightStr.equals("")) {
            return Integer.toString(root.val)+"("+leftStr+")";
        } else {
            return Integer.toString(root.val)+"("+leftStr+")"+"("+rightStr+")";
        }
    }
}
// @lc code=end

