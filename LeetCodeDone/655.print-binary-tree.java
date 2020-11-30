import java.util.*;
/*
 * @lc app=leetcode id=655 lang=java
 *
 * [655] Print Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public List<List<String>> printTree(TreeNode root) {
    List<List<String>> res = new ArrayList<>();
    if (root == null) return res;
    int row = getHeight(root);
    int col = (int) Math.pow(2, row) - 1; // 2^n - 1
    for (int r = 0; r < row; r++) {
      res.add(new ArrayList<String>());
      for (int c = 0; c < col; c++) {
        res.get(r).add("");
      }
    }
    dfs(root, 0, 0, col - 1, res);
    return res;
  }
  
  private void dfs(TreeNode root, int curRow, int left, int right, List<List<String>> res) {
    if (root == null || curRow == res.size()) {
      return;
    }
    int mid = left + (right - left) / 2;
    res.get(curRow).set(mid, String.valueOf(root.val));
    dfs(root.left, curRow+1, left, mid - 1, res);
    dfs(root.right, curRow+1, mid+1, right, res);

  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
}
// @lc code=end
