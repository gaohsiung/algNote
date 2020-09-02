import java.util.*;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while(size -- > 0) {
                TreeNode cur = bfsQueue.poll();
                if(cur.left != null) {
                    bfsQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    bfsQueue.offer(cur.right);
                }
                if (size == 0) {
                    res.add(cur.val);
                }
            }
        }
        return res;
    }
}
// @lc code=end

