/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = minDepth(root.left);
        int rightH = minDepth(root.right);

        if (leftH == 0 && rightH == 0) {
            return 1;
        } else if (leftH != 0 && rightH != 0) {
            return Math.min(leftH, rightH) + 1;
        } else {
            return leftH == 0 ? rightH+1:leftH+1;
        }
        
    }
}
// @lc code=end

