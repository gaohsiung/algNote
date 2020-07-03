/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == p.val || cur.val == q.val || (cur.val > p.val && cur.val < q.val)) {
                return cur;
            }
            if (cur.val < p.val) {
                cur = cur.right;
            }
            if (cur.val > q.val) {
                cur = cur.left;
            }

        }
        return null;
    }
}
// @lc code=end

