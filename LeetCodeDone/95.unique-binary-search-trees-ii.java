import java.util.*;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        if (start > end) {
            List<TreeNode> ret = new LinkedList<>();
            ret.add(null);
            return ret;
        }
        List<TreeNode> ret = new LinkedList<>();
        for(int i = start; i <= end; i++) {
            List<TreeNode> lefts = dfs(start, i-1);
            List<TreeNode> rights = dfs(i+1, end);

            for (TreeNode left: lefts) {
                for(TreeNode right: rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
// @lc code=end

