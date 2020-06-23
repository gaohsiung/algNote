import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pop();
                }
            } else if (prev == cur.left) {
                if (cur.right == null) {
                    res.add(cur.val);
                    stack.pop();
                } else {
                    stack.push(cur.right);
                }
            } else if (prev == cur.right) {
                res.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return res;
    }
}
// @lc code=end
