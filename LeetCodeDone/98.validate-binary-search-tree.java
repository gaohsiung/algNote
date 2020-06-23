/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        int[] range = isValid(root);
        return range != null && (range[0] <= root.val) && (root.val <= range[1]);
    }

    private int[] isValid(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0, 0};
        }
        
        int[] leftRange = isValid(root.left);
        int[] rightRange = isValid(root.right);
        if (leftRange == null || rightRange == null) {
            return null;
        }
        if (leftRange[2] == 0 && rightRange[2] == 0) {
            return new int[]{root.val, root.val, 1};
        } else if (leftRange[2] == 0) {
            if (root.val >= rightRange[0]) {
                return null;
            } else {
                return new int[] {root.val, rightRange[1], 1};
            }
        } else if (rightRange[2] == 0) {
            if (root.val <= leftRange[1]) {
                return null;
            } else {
                return new int[] {leftRange[0], root.val, 1};
            }
        }
        if (leftRange[1] >= root.val || rightRange[0] <= root.val) {
            return null;
        }
        return new int[] {leftRange[0], rightRange[1], 1};
    }
    
}
// @lc code=end

