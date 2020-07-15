/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        TreeNode[] mistakes = new TreeNode[2];
        dfs(root, mistakes);
        int temp = mistakes[0].val;
        mistakes[0].val = mistakes[1].val;
        mistakes[1].val = temp;
        
    }
    
    private void dfs(TreeNode root, TreeNode[] mistakes) {
        if (root == null) {
            return;
        }
        dfs(root.left, mistakes);

        if (prev != null && prev.val > root.val) {
            mistakes[1] = root;
            if (mistakes[0] == null) {
                mistakes[0] = prev;
            }
        }
        prev = root;
        dfs(root.right, mistakes);

    }

    public static void main(String[] args) {

    }
}
// @lc code=end

