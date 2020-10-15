import java.util.*;
/*
 * @lc app=leetcode id=545 lang=java
 *
 * [545] Boundary of Binary Tree
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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        traverseLeft(root.left, res);
        traverseLeaves(root.left, res);
        traverseLeaves(root.right, res);
        traverseRight(root.right, res);
        return res;
    }
    private void traverseLeft(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.val);
        if (root.left == null) {
            traverseLeft(root.right, res);
        } else {
            traverseLeft(root.left, res);
        }
    }
    private void traverseRight(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right == null) {
            traverseRight(root.left, res);
        } else {
            traverseRight(root.right, res);
        }
        res.add(root.val);
    }
    private void traverseLeaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        traverseLeaves(root.left, res);
        traverseLeaves(root.right, res);
    }
}
// @lc code=end

