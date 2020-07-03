/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode dfs(int preorderIndex, int inorderStart, int inorderEnd, int[] preorder, int[] inorder) {
        if (preorderIndex >= preorder.length || inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootVal);
        int inorderInd = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                inorderInd = i;
            }
        }
        root.left = dfs(preorderIndex+1, inorderStart, inorderInd - 1, preorder, inorder);
        root.right = dfs(preorderIndex+(inorderInd - inorderStart + 1), inorderInd+1, inorderEnd, preorder, inorder);

        return root;
    }
}
// @lc code=end

