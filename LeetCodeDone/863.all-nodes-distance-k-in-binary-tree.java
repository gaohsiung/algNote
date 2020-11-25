import java.util.*;
/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    // c.c.
    List<Integer> res = new ArrayList<>();
    Map<TreeNode, TreeNode> getParent = new HashMap<>();
    traverseTree(root, null, getParent);
    Queue<TreeNode> queue = new LinkedList<>();
    Set<TreeNode> checkVisited = new HashSet<>();
    queue.offer(target);
    checkVisited.add(target);
    while (!queue.isEmpty() && k > 0) {
      int size = queue.size();
      while (size -- > 0) {
        TreeNode cur = queue.poll();
        if (cur.left != null && !checkVisited.contains(cur.left)) {
          queue.offer(cur.left);
          checkVisited.add(cur.left);
        }
        if (cur.right != null && !checkVisited.contains(cur.right)) {
          queue.offer(cur.right);
          checkVisited.add(cur.right);
        }
        if (getParent.get(cur) != null && !checkVisited.contains(getParent.get(cur))) {
          queue.offer(getParent.get(cur));
          checkVisited.add(getParent.get(cur));
        }
      }
      k--;      
    }
    while (!queue.isEmpty()) {
      res.add(queue.poll().val);
    }
    return res;
  }
  private void traverseTree(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> getParent) {
    if (root == null) {
      return;
    }
    getParent.put(root, parent);
    traverseTree(root.left, root, getParent);
    traverseTree(root.right, root, getParent);
  }
}
// @lc code=end
