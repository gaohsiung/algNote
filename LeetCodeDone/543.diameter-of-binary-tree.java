/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    int globalMax;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        this.globalMax = 0;
        helper(root);
        return this.globalMax - 1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftL = helper(root.left);
        int rightL = helper(root.right);
        this.globalMax = Math.max(this.globalMax, leftL+rightL + 1);
        return Math.max(leftL, rightL) + 1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(sol.diameterOfBinaryTree(t1));

    }

    

}
// @lc code=end

