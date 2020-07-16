/*
 * @lc app=leetcode id=333 lang=java
 *
 * [333] Largest BST Subtree
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
    class MyCell {
        int min;
        int max;
        int size;
        MyCell(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    private int largest = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return largest;
        }
        dfs(root);
        return largest;
    }
    private MyCell dfs(TreeNode root) {
        if (root == null) {
            return new MyCell(0,0,0);
        }
        MyCell leftCell = dfs(root.left);
        MyCell rightCell = dfs(root.right);
        if (leftCell == null || rightCell == null) {
            return null;
        }

        if ((leftCell.size == 0 || leftCell.max < root.val)
            && (rightCell.size == 0 || rightCell.min > root.val)) {
            int rootMin = leftCell.size == 0?root.val:leftCell.min;
            int rootMax = rightCell.size == 0?root.val:rightCell.max;
            int rootSize = leftCell.size + rightCell.size + 1;
            largest = Math.max(largest, rootSize);
            return new MyCell(rootMin, rootMax, rootSize);
        }
        return null;
    }
}
// @lc code=end

