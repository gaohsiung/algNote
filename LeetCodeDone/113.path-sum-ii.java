import java.util.*;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(root, sum, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> sol, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            sol.add(root.val);
            res.add(new LinkedList<Integer>(sol));
            sol.remove(sol.size() - 1);
            return;
        }
        sol.add(root.val);
        dfs(root.left, sum - root.val, sol, res);
        dfs(root.right, sum - root.val, sol, res);
        sol.remove(sol.size() - 1);
    }
}
// @lc code=end

