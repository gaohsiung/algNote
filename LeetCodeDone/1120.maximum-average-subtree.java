/*
 * @lc app=leetcode id=1120 lang=java
 *
 * [1120] Maximum Average Subtree
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
    private double maxAvgSubTree = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) throw new IllegalArgumentException();
        traverseTree(root);
        return maxAvgSubTree;
    }
    private double[] traverseTree(TreeNode root) { // [sum, num of node]
        if (root == null) {
            return new double[]{0.0, 0.0};
        }
        double[] leftRes = traverseTree(root.left);
        double[] rightRes = traverseTree(root.right);
        double curSum = leftRes[0] + rightRes[0] + ((double) root.val);
        double curNum = leftRes[1] + rightRes[1] + 1.0;
        double curAvg = curSum / curNum;
        maxAvgSubTree = Math.max(maxAvgSubTree, curAvg);
        return new double[]{curSum, curNum};
    }
}
// @lc code=end

