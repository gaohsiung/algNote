import java.util.*;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null 
            || inorder.length == 0 || postorder.length == 0 
            || inorder.length != postorder.length) {
                return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(postorder.length - 1, 0, inorder.length - 1, inorder, postorder, inorderMap);

    }

    private TreeNode dfs(int postInd, int inStart, int inEnd, int[] inorder, 
            int[] postorder, Map<Integer, Integer> inorderMap) {
        if (postInd < 0 || inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postInd];
        int inMid = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(postInd - (inEnd - inMid) - 1, inStart, inMid - 1, inorder, postorder, inorderMap);
        root.right = dfs(postInd - 1, inMid + 1, inEnd, inorder, postorder, inorderMap);

        return root;
    }
}
// @lc code=end

