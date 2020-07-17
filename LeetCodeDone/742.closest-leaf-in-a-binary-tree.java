import java.util.*;

import javax.management.RuntimeErrorException;

/*
 * @lc app=leetcode id=742 lang=java
 *
 * [742] Closest Leaf in a Binary Tree
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
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        Map<TreeNode, TreeNode> findParentMap = new HashMap<>();
        TreeNode nodeK = dfs(root, k, findParentMap);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(nodeK);
        Set<TreeNode> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return cur.val;
                }
                if (cur.left != null && (!visited.contains(cur.left))) {
                    q.offer(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && (!visited.contains(cur.right))) {
                    q.offer(cur.right);
                    visited.add(cur.right);
                }
                if (findParentMap.containsKey(cur) && (!visited.contains(findParentMap.get(cur)))) {
                    q.offer(findParentMap.get(cur));
                    visited.add(findParentMap.get(cur));
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> findParentMap) {
        if (root.val == k) {
            return root;
        }
        if (root.left != null) {
            findParentMap.put(root.left, root);
            TreeNode leftHasK = dfs(root.left, k, findParentMap);
            if (leftHasK != null) {
                return leftHasK;
            }
        }
        if (root.right != null) {
            findParentMap.put(root.right, root);
            TreeNode rightHasK = dfs(root.right, k, findParentMap);
            if (rightHasK != null) {
                return rightHasK;
            }
        }
        return null;
    }
}
// @lc code=end

