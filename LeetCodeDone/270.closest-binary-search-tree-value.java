/*
 * @lc app=leetcode id=270 lang=java
 *
 * [270] Closest Binary Search Tree Value
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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        TreeNode cur = root;
        int prevClosest = root.val;
        int curVal;
        while (cur != null) {
            curVal = cur.val;
            if (target == curVal) {
                return cur.val;
            } else if (target < curVal) {
                if (Math.abs(prevClosest - target) > Math.abs(curVal - target)) {
                    prevClosest = curVal;
                }
                cur = cur.left;
            } else {
                if (Math.abs(prevClosest - target) > Math.abs(curVal - target)) {
                    prevClosest = curVal;
                }
                cur = cur.right;
            }
        }
        return prevClosest;
    }
}
// @lc code=end

