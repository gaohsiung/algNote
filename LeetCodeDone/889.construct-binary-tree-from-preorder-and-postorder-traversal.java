/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length == 0 || post.length == 0 || pre.length != post.length) {
            return null;
        }
        return dfs(0, pre.length - 1, 0, post.length - 1, pre, post);
    }

    private TreeNode dfs(int preStart, int preEnd, int postStart, int postEnd, int[] pre, int[] post) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        int postLeftEndIndex = 0;
        for (int i = postStart; i < postEnd; i++) {
            if (pre[preStart+1] == post[i]) {
                postLeftEndIndex = i;
                break;
            }
        }
        int preLeftEndIndex = preStart + postLeftEndIndex - postStart + 1;
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = dfs(preStart+1, preLeftEndIndex, postStart, postLeftEndIndex, pre, post);
        root.right = dfs(preLeftEndIndex+1, preEnd, postLeftEndIndex+1, postEnd - 1, pre, post);
        return root;
    }
}
// @lc code=end

