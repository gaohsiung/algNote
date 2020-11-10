/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    int maxIdx = findMaxIdx(nums, 0, nums.length - 1);
    return constructMaxTree(nums, 0, maxIdx, nums.length - 1);
  }

  private TreeNode constructMaxTree(int[] nums, int startIdx, int maxIdx, int endIdx) {
    TreeNode root = new TreeNode(nums[maxIdx]);
    if (startIdx == maxIdx) {
      root.left = null;
    } else {
      int leftMaxIdx = findMaxIdx(nums, startIdx, maxIdx - 1);
      root.left = constructMaxTree(nums, startIdx, leftMaxIdx, maxIdx - 1);
    }
    if (endIdx == maxIdx) {
      root.right = null;
    } else {
      int rightMaxIdx = findMaxIdx(nums, maxIdx+1, endIdx);
      root.right = constructMaxTree(nums, maxIdx+1, rightMaxIdx, endIdx);
    }
    return root;
  }

  private int findMaxIdx(int[] nums, int startIdx, int endIdx) { // [startIdx, endIdx]
    int res = startIdx;
    for (int i = startIdx; i <= endIdx; i++) {
      if (nums[res] < nums[i]) {
        res = i;
      }
    }
    return res;
  }
}
// @lc code=end
