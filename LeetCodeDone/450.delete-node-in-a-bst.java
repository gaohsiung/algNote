/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        TreeNode toBeSwitched;
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null) {
            toBeSwitched = root.right;
            while(toBeSwitched.left != null) {
                toBeSwitched = toBeSwitched.left;
            }
            root.val = toBeSwitched.val;
            root.right = deleteNode(root.right, root.val);
        } else {
            toBeSwitched = root.left;
            while(toBeSwitched.right != null) {
                toBeSwitched = toBeSwitched.right;
            }
            root.val = toBeSwitched.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        // TreeNode t7 = new TreeNode(7, null, null);
        // TreeNode t6 = new TreeNode(5, null, null);
        // TreeNode t5 = new TreeNode(3, null, null);
        // TreeNode t4 = new TreeNode(1, null, null);
        // TreeNode t3 = new TreeNode(6, t6, t7);
        // TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(2, null, null);

        TreeNode root = new TreeNode(1, null, t3);

        sol.deleteNode(root, 2);

    }
}
// @lc code=end

