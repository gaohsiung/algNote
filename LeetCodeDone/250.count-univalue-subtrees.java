/*
 * @lc app=leetcode id=250 lang=java
 *
 * [250] Count Univalue Subtrees
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
    //https://vimeo.com/403362835 1:57:00
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return count;
    }

    private boolean dfs(TreeNode root, int target) {
        if (root == null) {
            return true;
        }
        boolean leftValid = dfs(root.left, root.val);
        boolean rightValid = dfs(root.right, root.val);
        if (!leftValid || !rightValid) {
            return false;
        }
        count++;
        return root.val == target;
    }


}
// @lc code=end

