import java.util.*;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    private int dfs(TreeNode root, int level, int order, ArrayList<Integer> left, ArrayList<Integer> right) {
        if (root == null) {
            return 0;
        }
        if (level == left.size()) {
            left.add(order);
            right.add(order);
        } else {
            right.set(level, order);
        }
        int cur = right.get(level) - left.get(level) + 1;
        int leftChild = dfs(root.left, level+1, order*2, left, right);
        int rightChild = dfs(root.right, level+1, order*2+1, left, right);
        return Math.max(cur, Math.max(leftChild, rightChild)); // rightChild update the same two lists from leftChild 

    }

    public static void main(String[] ss) {
        Solution s= new Solution();
        TreeNode t7 = new TreeNode(7);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, null, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(s.widthOfBinaryTree(t1));
    }
}
// @lc code=end

