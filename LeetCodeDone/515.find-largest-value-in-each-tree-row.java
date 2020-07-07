import java.util.*;

/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int levelMax = Integer.MIN_VALUE;
            while(size-- > 0) {
                TreeNode cur = q.poll();
                levelMax = Math.max(levelMax, cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(levelMax);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        Solution sol = new Solution();
        
        System.out.println(sol.largestValues(t1));

    }
}
// @lc code=end

