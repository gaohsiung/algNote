import java.util.*;
/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> forest = new ArrayList<>();
    Set<Integer> removedSet = new HashSet<>();
    for (int i: to_delete) {
      removedSet.add(i);
    }
    traverseTree(root, true, forest, removedSet);
    return forest;
  }
  private TreeNode traverseTree(TreeNode root, boolean isAdded, List<TreeNode> res, Set<Integer> removedSet) {
    if (root == null) {
      return null;
    }
    if (isAdded && !removedSet.contains(root.val)) {
      res.add(root);
    }
    TreeNode returnNode = root;
    if (removedSet.contains(root.val)) {
      returnNode = null;
      isAdded = true;
    } else {
      isAdded = false;
    }

    TreeNode left = traverseTree(root.left, isAdded, res, removedSet);
    TreeNode right = traverseTree(root.right, isAdded, res, removedSet);
    root.left = left;
    root.right = right;
    return returnNode;
  }
}
// @lc code=end
