import java.util.*;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> rToLNums = new LinkedList<>();
        dfs(root, 0, rToLNums);
        int sum = 0;
        for(int i: rToLNums) {
            sum += i;
        }
        return sum;
    }

    private void dfs(TreeNode root, int cur, List<Integer> rToLNums) {
        if (root.left == null && root.right == null) {
            rToLNums.add(cur*10+root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, cur * 10 + root.val, rToLNums);
        }
        if (root.right != null) {
            dfs(root.right, cur * 10 + root.val, rToLNums);
        }
    }
}
// @lc code=end

