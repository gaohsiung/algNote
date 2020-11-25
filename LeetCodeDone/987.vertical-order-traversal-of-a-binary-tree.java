import java.util.*;
/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
    Queue<Integer> locationQueue = new ArrayDeque<>();
    treeNodeQueue.offer(root);
    locationQueue.offer(0);
    int leftBound = 0;
    int rightBound = 0;
    Map<Integer, List<Integer>> locToNodeList = new HashMap<>();
    while (!treeNodeQueue.isEmpty()) {
      int size = treeNodeQueue.size();
      Map<Integer, List<Integer>> tempMap = new HashMap<>();
      while (size-- > 0) {
        TreeNode curNode = treeNodeQueue.poll();
        int curLoc = locationQueue.poll();
        leftBound = Math.min(leftBound, curLoc);
        rightBound = Math.max(rightBound, curLoc);
        if (!tempMap.containsKey(curLoc)) {
          tempMap.put(curLoc, new ArrayList<Integer>());
        }
        tempMap.get(curLoc).add(curNode.val);
        if (curNode.left != null) {
          treeNodeQueue.add(curNode.left);
          locationQueue.add(curLoc - 1);
        }
        if (curNode.right != null) {
          treeNodeQueue.add(curNode.right);
          locationQueue.add(curLoc + 1);
        }
      }
      for (Map.Entry<Integer, List<Integer>> e: tempMap.entrySet()) {
        if (!locToNodeList.containsKey(e.getKey())) {
          locToNodeList.put(e.getKey(), new ArrayList<Integer>());
        }
        Collections.sort(e.getValue());
        for (int i: e.getValue()) {
          locToNodeList.get(e.getKey()).add(i);
        }
      }
    }
    return convertMapToList(locToNodeList, leftBound, rightBound);
  }
  private List<List<Integer>> convertMapToList(Map<Integer, List<Integer>> locToNodeList, int left, int right) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      res.add(locToNodeList.get(i));
    }
    return res;
  }
}
// @lc code=end
