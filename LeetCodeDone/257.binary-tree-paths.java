import java.util.*;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(root, new StringBuilder(), res);
        return res;
        
    }

    private void dfs(TreeNode root, StringBuilder path, List<String> res) {

        int pathLen = path.length();
        if (path.length() != 0) {
            path.append("->");
        }
        path.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(path.toString());
            path.setLength(pathLen);
            return;
        } else if (root.left == null) {
            dfs(root.right, path, res);
            path.setLength(pathLen);
        } else if (root.right == null) {
            dfs(root.left, path, res);
            path.setLength(pathLen);
        } else {
            dfs(root.left, path, res);
            dfs(root.right, path, res);
            path.setLength(pathLen);
        }
    }
}
// @lc code=end

