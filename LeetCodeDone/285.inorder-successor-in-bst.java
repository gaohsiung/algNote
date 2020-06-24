import java.util.Stack;

/*
 * @lc app=leetcode id=285 lang=java
 *
 * [285] Inorder Successor in BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean flag = false;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (flag) {
                    return cur;
                }
                if (cur == p) {
                    flag = true;
                }
                cur = cur.right;
            }
        }
        return null;
    }
}
// @lc code=end

