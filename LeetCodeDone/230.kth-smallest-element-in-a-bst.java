import java.util.*;

/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        prepareStack(stack, root);
        TreeNode cur = root;
        while(k -- > 0 && (!stack.isEmpty())) {
            cur = stack.pop();
            if(cur.right != null) {
                prepareStack(stack, cur.right);
            }
        }
        return cur.val;
    }


    private void prepareStack(Stack<TreeNode> stack, TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}
// @lc code=end

