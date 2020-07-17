import java.util.*;

/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        List<Integer> res = new LinkedList<>();
        dfs(root, L, R, res);
        int sum = 0;
        for(int i: res) {
            sum += i;
        }
        return sum;
    }

    private void dfs(TreeNode root, int l, int r, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.val < l) {
            dfs(root.right, l, r, res);
        } else if (root.val > r) {
            dfs(root.left, l, r, res);
        } else {
            res.add(root.val);
            dfs(root.left, l, r, res);
            dfs(root.right, l, r, res);
        }
    }
}
// @lc code=end

