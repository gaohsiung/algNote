/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        int nodeNum;
        if (leftH > rightH) {
            nodeNum = 1 << rightH;
            return countNodes(root.left) + nodeNum;
        } else if (leftH == rightH) {
            nodeNum = 1 << leftH;
            return countNodes(root.right) + nodeNum;
        }
        return -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        while (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }
    public static void main(String[] ss) {

    }
}
// @lc code=end

