import java.util.*;

/*
 * @lc app=leetcode id=894 lang=java
 *
 * [894] All Possible Full Binary Trees
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
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 0 || n == 2) {
            List<TreeNode> res = new LinkedList<>();
            return res;
        }
        if (n == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        List<TreeNode> res = new LinkedList<>();
        for (int i = 1; i <= n - 2; i++) {
            List<TreeNode> lefts = allPossibleFBT(i);
            if (lefts.size() == 0) {
                continue;
            }
            List<TreeNode> rights = allPossibleFBT(n - i - 1);
            if (rights == null) {
                continue;
            }
            for (TreeNode l: lefts) {
                for (TreeNode r: rights) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }

        }
        return res;
        

    }
}
// @lc code=end

